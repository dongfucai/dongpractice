package reference;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.LinkedList;

/**
 * @Package Name : ${PACKAG_NAME}
 * @Author : 1766318593@qq.com
 * @Creation Date : 2018年05月11日下午5:06
 * @Function : todo
 */

//  软引用  内存空间足够的时候，垃圾回收器不会回收它，如果内存空间不足了，就会回收这些对象的内存
//  弱引用  比软引用更次， 在垃圾回收器线程扫描它所管辖的内存区域过程中，一旦发现了具有弱饮用的对象 不管内存空间是否足够，都会回收他
//  由于垃圾回收器的优先级别很低，不一定很快发现  这些只是具有弱引用的对象



public class ReferenceTest {


        private static ReferenceQueue<VeryBig> rq = new ReferenceQueue<VeryBig>();

        public static void checkQueue() {
            Reference<? extends VeryBig> ref = null;
            while ((ref = rq.poll()) != null) {
                if (ref != null) {
                    System.out.println("In queue: " + ((VeryBigWeakReference) (ref)).id);
                }
            }
        }

        public static void main(String args[]) {
            int size = 3;
            LinkedList<WeakReference<VeryBig>> weakList = new LinkedList<WeakReference<VeryBig>>();
            for (int i = 0; i < size; i++) {
                weakList.add(new VeryBigWeakReference(new VeryBig("Weak " + i), rq));
                System.out.println("Just created weak: " + weakList.getLast());

            }

            System.gc(); // 主动抵用gc
            System.gc();
            try { // 下面休息几分钟，让上面的垃圾回收线程运行完成
                Thread.currentThread().sleep(6000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            checkQueue();
        }
    }

    class VeryBig {
        public String id;
        // 占用空间,让线程进行回收
        byte[] b = new byte[2 * 1024];

        public VeryBig(String id) {
        this.id = id;
        }

        @Override
        protected void finalize() {
        System.out.println("Finalizing VeryBig " + id);
        }
    }

    class VeryBigWeakReference extends WeakReference<VeryBig> {
        public String id;

        public VeryBigWeakReference(VeryBig big, ReferenceQueue<VeryBig> rq) {
        super(big, rq);
        this.id = big.id;
        }

        @Override
        protected void finalize() {
            System.out.println("Finalizing VeryBigWeakReference " + id);
        }

    }
