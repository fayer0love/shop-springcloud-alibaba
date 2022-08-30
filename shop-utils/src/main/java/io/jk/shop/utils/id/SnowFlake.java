package io.jk.shop.utils.id;

/**
 * @author shiyangli
 * @version 1.0.0
 * @description snowflake id generator
 */
public class SnowFlake {

    /**
     * start time: 2022-04-12 11:56:45, cannot be modified
     */
    private final static long START_STAMP = 1649735805910L;

    /**
     * bits of each part
     */
    private final static long SEQUENCE_BIT = 12; // sequence number
    private final static long MACHINE_BIT = 5; // machine id
    private final static long DATACENTER_BIT = 5; // data center id

    /**
     * max value of each part
     */
    private final static long MAX_DATACENTER_NUM = ~(-1L << DATACENTER_BIT);
    private final static long MAX_MACHINE_NUM = ~(-1L << MACHINE_BIT);
    private final static long MAX_SEQUENCE = ~(-1L << SEQUENCE_BIT);

    /**
     * left shift of each part
     */
    private final static long MACHINE_LEFT = SEQUENCE_BIT;
    private final static long DATACENTER_LEFT = SEQUENCE_BIT + MACHINE_BIT;
    private final static long TIMESTMP_LEFT = DATACENTER_LEFT + DATACENTER_BIT;

    private long datacenterId; // data center id
    private long machineId; // machine id
    private long sequence = 0L; // sequence number
    private long lastStmp = -1L; // last timestamp

    public SnowFlake(long datacenterId, long machineId) {
        if (datacenterId > MAX_DATACENTER_NUM || datacenterId < 0) {
            throw new IllegalArgumentException("datacenterId can't be greater than MAX_DATACENTER_NUM or less than 0");
        }
        if (machineId > MAX_MACHINE_NUM || machineId < 0) {
            throw new IllegalArgumentException("machineId can't be greater than MAX_MACHINE_NUM or less than 0");
        }
        this.datacenterId = datacenterId;
        this.machineId = machineId;
    }

    /**
     * generate next id
     */
    public synchronized long nextId() {
        long currStmp = getNewstmp();
        if (currStmp < lastStmp) {
            throw new RuntimeException("Clock moved backwards.  Refusing to generate id");
        }

        if (currStmp == lastStmp) {
            // same millisecond, sequence number plus 1
            sequence = (sequence + 1) & MAX_SEQUENCE;
            // sequence number overflow in the same millisecond
            if (sequence == 0L) {
                currStmp = getNextMill();
            }
        } else {
            // different millisecond, sequence number starts from 0
            sequence = 0L;
        }

        lastStmp = currStmp;

        return (currStmp - START_STAMP) << TIMESTMP_LEFT // timestamp
                | datacenterId << DATACENTER_LEFT // data center id
                | machineId << MACHINE_LEFT // machine id
                | sequence; // sequence number
    }

    private long getNextMill() {
        long mill = getNewstmp();
        while (mill <= lastStmp) {
            mill = getNewstmp();
        }
        return mill;
    }

    private long getNewstmp() {
        return System.currentTimeMillis();
    }

    public static long getMaxDataCenterNum() {
        return MAX_DATACENTER_NUM;
    }

    public static long getMaxMachineNum() {
        return MAX_MACHINE_NUM;
    }

    public static void main(String[] args) {
        System.out.println(MAX_DATACENTER_NUM);
        System.out.println(MAX_MACHINE_NUM);
    }
}
