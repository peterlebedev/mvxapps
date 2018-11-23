package cz.lebedev.mvapp;

import dagger.Component;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import dagger.multibindings.StringKey;
import org.junit.Test;

import javax.inject.Singleton;

import java.util.Map;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */




@Module
class TestModule{

    @Provides
    @IntoMap
    @StringKey("item1")
    MyItem provideItem1(){
        return new MyItem("string1");
    }


    @Provides
    @IntoMap
    @StringKey("item2")
    MyItem provideItem2(){
        return new MyItem("string2");
    }

}

@Singleton
@Component(modules = {TestModule.class})
interface TestComponent{
    Map<String,MyItem> items();
}




public class DaggerMultibindingUnitTest {

    @Test
    public void shouldBindMultipleItems(){
       TestComponent test1Component = DaggerTestComponent.create();
        Map<String, MyItem> items = test1Component.items();
        boolean equals = items.get("item1").name.equals("string1");
        boolean equals2 = items.get("item2").name.equals("string2");
        assertTrue(equals);
        assertTrue(equals2);
    }

}