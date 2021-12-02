package tst

import org.junit.platform.engine.ConfigurationParameters
import org.junit.platform.engine.support.hierarchical.ParallelExecutionConfiguration
import org.junit.platform.engine.support.hierarchical.ParallelExecutionConfigurationStrategy

class CustomStrategy : ParallelExecutionConfiguration, ParallelExecutionConfigurationStrategy {
    override fun getParallelism() = 2

    override fun getMinimumRunnable() = 2


    override fun getMaxPoolSize() = 2

    override fun getCorePoolSize() = 2

    override fun getKeepAliveSeconds() = 30

    override fun createConfiguration(configurationParameters: ConfigurationParameters): ParallelExecutionConfiguration {
        return this
    }
}
