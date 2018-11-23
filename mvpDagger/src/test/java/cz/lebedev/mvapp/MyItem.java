package cz.lebedev.mvapp;

import javax.inject.Inject;

class MyItem{

    final String name;

    public MyItem (String name){
        this.name = name;
    }
}


class MyItem1 extends MyItem{

    @Inject
    public MyItem1(){
        super("String1");
    }
}

class MyItem2 extends MyItem{

    @Inject
    public MyItem2(){
        super("String2");
    }
}