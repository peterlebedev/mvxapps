package cz.lebedev.mvapp;

import dagger.Binds;
import dagger.Component;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import dagger.multibindings.StringKey;
import org.junit.Test;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Map;

import static org.junit.Assert.assertTrue;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

@Module
abstract class Test2Module{

    @Binds
    @IntoMap
    @StringKey("item1")
    abstract MyItem provideItem1(MyItem1 myItem1);

    @Binds
    @IntoMap
    @StringKey("item2")
    abstract MyItem provideItem2(MyItem2 myItem2);
}

class Item2Container{

    private Map<String, MyItem> items;

    @Inject
    public Item2Container(Map<String,MyItem> items){
        this.items = items;
    }

    Map<String, MyItem> getMyItems(){
        return items;
    }
}

@Singleton
@Component(modules = {Test2Module.class})
interface Test2Component{
    Item2Container item2Container();
}


public class DaggerMultibindingUnitTest2 {

    @Test
    public void shouldBindMultipleItems2(){
        Test2Component test1Component = DaggerTest2Component.create();
        Map<String, MyItem> items = test1Component.item2Container().getMyItems();
        boolean equals = items.get("item1").name.equals("String1");
        boolean equals2 = items.get("item2").name.equals("String2");
        assertTrue(equals);
        assertTrue(equals2);
    }

}