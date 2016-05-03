/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaFeature;

/**
 *
 * @author Sam
 */

class A{}
class B extends A{}
class C extends B{}
class D extends C{}
class Generics<T>{
	T t;
	void set(T t){
		this.t = t;
	}
	
}


public class JavaGenerics{ 
        
        public static void main(String[] args){
        //raw type
        Generics h1 ;//是java5兼容之前的代码没有泛型功能而提供的一个功能，
        //编译器不推荐最新写的代码使用到rawtype,编译器给与警告
        h1 = new Generics<Integer>();
        Object o = new Object();
        h1.set(o);//Type safety: The method set(Object) belongs to the raw type Generics. 
        //References to generic type Generics<T> should be parameterized
         	
        Generics<Object> h2;
        h2 = new Generics<Object>();
        //h2 = new Generics<Integer>();//error, 这里需要注意Generics<Object> 不是Generics<Integer>的父类； 
        //这两个是完全相同的类，凡是是不同的引用
        Generics<Integer> h3;
        h3 = new Generics<Integer>();
        System.out.println(h2.getClass() == h3.getClass());
        
        Generics<? extends A> h4; //任何继承于A的类的泛型
        h4 = new Generics<B>();
        //h4.set(new B()); //但因为？ extends A是一个不限定的class，即编译器不知道这个泛型的parameter参数到底是什么，
        //所以它不允许加入任何对象
        Generics<? super C> h5;//任何是C类父类的泛型
        h5 = new Generics<A>();
        h5.set(new D());//正确，编译器知道h5的类型参数是C的一个父类，所以放入C，只会发生向上转型
        //h5.set(new A());//error，因为编译器无法确定泛型参数会不会是B类，因为如果是B类，将A放入就会发生向下转型，
        //这是一个不保证安全的操作
        
        
        Generics<?> h6; // 不确定类型，所以不能亡里面加入任何对象
        h6 = new Generics<Integer>();
        //h6.set(1); //error h6的引用是？泛型，因为？是不确定的一个类型，所以编译器不允许调用任何操作
    }
        
        
    
}
