package com.kuake.rule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;

/**
 * @author hao
 * @create 2019-06-27 ${TIM}
 * 自定义负载均衡算法 规则  依旧是轮询算法  但是是经过3次调用之后 再进行轮询
 */
public class MyRule extends AbstractLoadBalancerRule {

    /**
     * Randomly choose from all living servers
     *
     */
    // 多线程环境下 可能会出现线程安全问题 使用可以使用ThreadLocad
    private Integer index = 0 ;  //server的index
    private Integer totalCount = 0; //被调用的次数
    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        }
        Server server = null;

        while (server == null) {
            if (Thread.interrupted()) {
                return null;
            }
            System.out.println(lb.getClass()+"==============================================================");
            List<Server> upList = lb.getReachableServers();
            List<Server> allList = lb.getAllServers();
            int serverup = upList.size();
            int serverCount = allList.size();
            if (serverCount == 0) {
                /*
                 * No servers. End regardless of pass, because subsequent passes
                 * only get more restrictive.
                 */
                return null;
            }

/*          这个是随机 负载均衡算法
            int index = chooseRandomInt(serverCount);
            server = upList.get(index);
*/
            if(totalCount<5){
                server = upList.get(index);
                // 访问次数加一
                totalCount++;
            }else {
                totalCount = 0;
                index++;
                //取余 轮询
                index = index%serverup;
            }
            if (server == null) {
                /*
                 * The only time this should happen is if the server list were
                 * somehow trimmed. This is a transient condition. Retry after
                 * yielding.
                 */
                Thread.yield();
                continue;
            }

            if (server.isAlive()) {
                return (server);
            }

            // Shouldn't actually happen.. but must be transient or a bug.
            server = null;
            Thread.yield();
        }

        return server;

    }


    @Override
    public Server choose(Object key) {
        return choose(getLoadBalancer(), key);
    }

    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }
}