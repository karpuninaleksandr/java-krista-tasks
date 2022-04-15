package reflect;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyQueue implements InvocationHandler {
    private final Object queue;

    private final FileOutputStream writer = new FileOutputStream("out.txt");

    public static Object newInstance(Object queue) throws IOException {
        return Proxy.newProxyInstance(
                queue.getClass().getClassLoader(),
                queue.getClass().getInterfaces(),
                new ProxyQueue(queue));
    }

    public ProxyQueue(Object object) throws IOException {
        this.queue = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, IOException {
        Method printQueue = queue.getClass().getDeclaredMethod("printQueue");
        printQueue.setAccessible(true);
        //"подключение" метода принтОчереди

        Method size = queue.getClass().getDeclaredMethod("size");
        size.setAccessible(true);
        //"подключение" метода размера

        Method isEmpty = queue.getClass().getDeclaredMethod("isEmpty");
        isEmpty.setAccessible(true);
        //"подключение" метода пустоты

        writer.write(
                ("Queue is empty: " + isEmpty.invoke(queue) + "\n"
                        + "Size of queue: " + size.invoke(queue) + "\n\n"
                        + printQueue.invoke(queue) + "\n")
                        .getBytes());
        //всякие сауты в файл out.txt для наглядности

        return method.invoke(queue, args);
    }
}
