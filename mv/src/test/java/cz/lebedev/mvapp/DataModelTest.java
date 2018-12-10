package cz.lebedev.mvapp;

import org.junit.Test;

import static org.junit.Assert.*;

public class DataModelTest {

    DataModel dataModel = new DataModel();

    @Test
    public void setGetData() {
        dataModel.setData("tmp");
        assertTrue(dataModel.getData().equals("tmp"));
    }


}