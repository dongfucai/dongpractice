package threadlocal.test;

/**
 * @Package Name : ${PACKAG_NAME}
 * @Author : 1766318593@qq.com
 * @Creation Date : 2018年05月11日上午11:05
 * @Function : todo
 */

/**
 * 　当使用ThreadLocal维护变量时，ThreadLocal为每个使用该变量的线程提供独立的变量副本，
 * 所以每一个线程都可以独立地改变自己的副本，而不会影响其它线程所对应的副本。
 * 　　从线程的角度看，目标变量就象是线程的本地变量，这也是类名中“Local”所要表达的意思。
 */

/**
 * 可以总结为一句话：ThreadLocal的作用是提供线程内的局部变量，这种变量在线程的生命周期内起作用，减少同一个线程内多个函数或者组件之间一些公共变量的传递的复杂度。
 * 举个例子，我出门需要先坐公交再做地铁，这里的坐公交和坐地铁就好比是同一个线程内的两个函数，
 * 我就是一个线程，我要完成这两个函数都需要同一个东西：公交卡（北京公交和地铁都使用公交卡），
 * 那么我为了不向这两个函数都传递公交卡这个变量（相当于不是一直带着公交卡上路），
 * 我可以这么做：将公交卡事先交给一个机构，当我需要刷卡的时候再向这个机构要公交卡（当然每次拿的都是同一张公交卡）。
 * 这样就能达到只要是我(同一个线程)需要公交卡，何时何地都能向这个机构要的目的。
 *
 */

/**
 * 静态内部类ThreadLocalMap定义在ThreadLocal里，但是ThreadLocalMap实例是从Thread里获取
 * ThreadLocal实际上并没有解决共享变量的线程安全问题，它只是把所谓的共享变量变成自己的变量而已。博主就这个地方有误区，其他说的不错
 */




/*
强调一下，ThreadLocal内部没有table，有table的是ThreadLocal的j静态内部类ThreadLocalMap，
既然是静态内部类，说明ThreadLocal和ThreadLocalMap是两个东西，只是以静态内部类的形式表明了ThreadLocal和ThreadLocalMap之间的关联关系。

ThreadLocal的作用只是一个工具，一个往线程的ThreadLocal.ThreadLocalMap塞指定数据的一个工具而已。

回到你的问题，ThreadLocal只能存1个值？不对，首先ThreadLocal不能存值，只是一个存值的工具。
其次就算是ThreadLocal.ThreadLocalMap，它也可以存任意多的值，而不是1个值，初始值16只是JDK给我们设定的一个比较合理的值而已。
不过我说真的，这点是比较难理解的，也是ThreadLocal里面的一个小的难点，得多去想想，当时我学习的时候也想了不少时间。

比方说：
ThreadLocal<Integer> tl0 = new ThreadLocal<Integer>();
ThreadLocal<Double> tl1 = new ThreadLocal<Double>();
ThreadLocal<Long> tl2 = new ThreadLocal<Long>();

对于特定的某个线程t来说，比如tl0.set(1)、tl1.set(1.1)、tl2.set(2)：
1、把tl0和1绑定作为一个Entry放入t的ThreadLocal.ThreadLocalMap的table中
2、把tl1和1.1绑定作为一个Entry放入t的ThreadLocal.ThreadLocalMap的table中
3、把tl2和2绑定作为一个Entry放入t的ThreadLocal.ThreadLocalMap的table中

大致上就是这么一个原理，get的时候也必须先判断table指定位置上的Entry中的ThreadLocal是否和tl0、tl1、tl2其中一个相同，相同才能拿数据。

 */




public class TestNum {

    // ①通过匿名内部类覆盖ThreadLocal的initialValue()方法，指定初始值
    private static ThreadLocal<Integer> seqNum = new ThreadLocal<Integer>(){
//
//        public Integer initailValue(){
//            return 0;
//        }

        /*
        protected Object initialValue()返回该线程局部变量的初始值，该方法是一个protected的方法，
        显然是为了让子类覆盖而设计的。这个方法是一个延迟调用方法，在线程第1次调用get()或set(Object)时才执行，
        并且仅执行1次。ThreadLocal中的缺省实现直接返回一个null。
         */
        public Integer initialValue() {
            return 0;
        }
    };


    private static ThreadLocal<Double> t1 = new ThreadLocal<Double>(){  // 这样同一个线程下就会 seqNum 和 t1 会放到 ThreadLocalMap 中
        public Double initialValue(){
            return 3.4;
        }
    };



    //2  获取下一个序列值
    public int getNextNum(){
        seqNum.set(seqNum.get()+1);
        return seqNum.get();
    }




    public static void main(String[] args) {

        TestNum sn = new TestNum();
        //3 个线程共享sn  各自 产生序列号
        TestClient t1 = new TestClient(sn);
        TestClient t2 = new TestClient(sn);
        TestClient t3 = new TestClient(sn);

        t1.start();
        t2.start();
        t3.start();



    }


    /*
    通过ThreadLocal为每一个线程提供了单独的副本。
     */

    private static class TestClient extends Thread {
        private TestNum sn;

        public TestClient(TestNum sn){
            this.sn = sn;
        }

        @Override
        public void run(){
            for(int i=0;i<3;++i){
                //4  每个线程打印 3 个序列值
                System.out.println("thread["+Thread.currentThread().getName() +"]----> sn["+ sn.getNextNum()+"]");
                System.out.println("thread["+Thread.currentThread().getName() +"]----> sn["+ t1.get()+"]");

            }
        }

    }

}
