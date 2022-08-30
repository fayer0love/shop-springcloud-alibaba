package io.jk.shop.utils.id;

/**
 * @author shiyangli
 * @version 1.0.0
 * @description snowflake factory
 */
public class SnowFlakeFactory {

    /**
     * default data center id
     */
    private static final long DEFAULT_DATA_CENTER_ID = 1L;

    /**
     * default worker id
     */
    private static final long DEFAULT_WORKER_ID = 1L;

    /**
     * default SnowFlake handler
     */
    private static final String DEFAULT_SNOW_FLAKE = "snow_flake";

    /**
     * cache SnowFlake object
     */
    private static final java.util.concurrent.ConcurrentMap<String, SnowFlake> snowFlakeCache = new java.util.concurrent.ConcurrentHashMap<>(2);

    private static SnowFlake getSnowFlake(long dataCenterId, long workerId) {
        return new SnowFlake(dataCenterId, workerId);
    }

    private static SnowFlake getSnowFlake() {
        return new SnowFlake(DEFAULT_DATA_CENTER_ID, DEFAULT_WORKER_ID);
    }

    public static SnowFlake getSnowFlakeFromCache() {
        SnowFlake snowFlake = snowFlakeCache.get(DEFAULT_SNOW_FLAKE);
        if (snowFlake == null) {
            snowFlake = new SnowFlake(DEFAULT_DATA_CENTER_ID, DEFAULT_WORKER_ID);
            snowFlakeCache.put(DEFAULT_SNOW_FLAKE, snowFlake);
        }
        return snowFlake;
    }

    /**
     * get global id from cache by data center id and worker id
     *
     * @param dataCenterId: value range is 1~31
     * @param machineId:    value range is 1~31
     */
    public static SnowFlake getSnowFlakeByDataCenterIdAndMachineIdFromCache(Long dataCenterId, Long machineId) {
        if (dataCenterId > SnowFlake.getMaxDataCenterNum() || dataCenterId < 0) {
            throw new IllegalArgumentException("datacenterId can't be greater than MAX_DATACENTER_NUM or less than 0");
        }
        if (machineId > SnowFlake.getMaxMachineNum() || machineId < 0) {
            throw new IllegalArgumentException("machineId can't be greater than MAX_MACHINE_NUM or less than 0");
        }
        String key = DEFAULT_SNOW_FLAKE.concat("_").concat(String.valueOf(dataCenterId))
                .concat("_").concat(String.valueOf(machineId));
        SnowFlake snowFlake = snowFlakeCache.get(key);
        if (snowFlake == null) {
            snowFlake = new SnowFlake(dataCenterId, machineId);
            snowFlakeCache.put(key, snowFlake);
        }
        return snowFlake;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(getSnowFlakeFromCache().nextId());
        }
    }
}
