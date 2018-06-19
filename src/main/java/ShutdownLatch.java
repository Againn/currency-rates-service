import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class ShutdownLatch implements ShutdownLatchMBean{

    protected  AtomicBoolean running = new AtomicBoolean(false);

    public long checkIntervalInseconds = 10;

    private String domain = "com.wacai.lifecycles";

    public ShutdownLatch(){

    }

    public ShutdownLatch(String domain){
        this.domain = domain;
    }

    public void await() throws Exception{
        if(running.compareAndSet(false,true)){
            MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
            mBeanServer.registerMBean(this,new ObjectName(domain,"name","ShutdownLatch"));
            while(running.get()){
                TimeUnit.SECONDS.sleep(checkIntervalInseconds);
            }
        }

    }
    public String shutdown() {
        if(running.compareAndSet(true,false)){
            return "shutdown signal sent,shutting down...";
        }else{
            return "shutdown singal had bean sent,no need again and again and again...";
        }
    }

    public static void main(String[] args) throws Exception{
        ShutdownLatch latch = new ShutdownLatch("your_domain_for_mbeans");
        latch.await();
    }
}
