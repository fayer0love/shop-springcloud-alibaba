package io.jk.shop.utils.test;

import io.jk.shop.utils.id.SnowFlakeFactory;
import io.jk.shop.utils.id.SnowFlakeLoader;
import org.junit.jupiter.api.Test;

/**
 * @author shiyangli
 * @version 1.0.0
 * @description snowflake test
 */
public class SnowFlakeFactoryTest {
    @org.junit.jupiter.api.Test
    public void testCreateDefaultID(){
        for(int i = 0; i < 100; i++){
            System.out.println(SnowFlakeFactory.getSnowFlakeFromCache().nextId());
        }
    }

    @Test
    public void testCreateID(){
        for(int i = 0; i < 100; i++){
            System.out.println(SnowFlakeFactory.getSnowFlakeByDataCenterIdAndMachineIdFromCache(SnowFlakeLoader.getDataCenterId(), SnowFlakeLoader.getDataCenterId()).nextId());
        }
    }
}
