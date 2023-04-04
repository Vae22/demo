package com.example.demo.executor;

import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author liminghao.
 * @date 2022/7/9
 * @time 23:52
 */
@Configuration
@EnableAsync
@Data
public class ExecutorConfig{
    /**
     * 核心线程
     */
    private static final int corePoolSize = 3;
    /**
     * 最大线程
     */
    private static final int maxPoolSize = 5;
    /**
     * 队列容量
     */
    private static final int queueCapacity = 3;
    /**
     * 保持时间
     */
    private static final int keepAliveSeconds = 3;
    /**
     * 名称前缀
     */
    private static final String preFix = "Async-Service-";

    @Bean("myExecutor")
    public Executor myExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(corePoolSize);
        executor.setMaxPoolSize(maxPoolSize);
        executor.setQueueCapacity(queueCapacity);
        executor.setKeepAliveSeconds(keepAliveSeconds);
        executor.setThreadNamePrefix(preFix);

        // 线程池对拒绝任务的处理策略
        executor.setRejectedExecutionHandler( new ThreadPoolExecutor.AbortPolicy());
        // 初始化
        executor.initialize();
        return executor;
    }
}
