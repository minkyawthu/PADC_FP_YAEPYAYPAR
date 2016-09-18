package com.padc.yaepyaypar.model;

import android.util.Log;

import com.padc.yaepyaypar.YaePyayParApp;
import com.padc.yaepyaypar.vos.YayPayParVo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kaungkhantthu on 9/17/16.
 */
public class YaypayparModel extends BaseModel {
    public static final String BROADCAST_DATA_LOADED = "BROADCAST_DATA_LOADED";

    private static YaypayparModel objInstance;

    private List<YayPayParVo> yayPayParVoList;

    private YaypayparModel() {
        super();
        yayPayParVoList = new ArrayList<>();
        //loadyaypaypar();
    }

    public static YaypayparModel getInstance() {
        if (objInstance == null) {
            objInstance = new YaypayparModel();
        }
        return objInstance;
    }

    public void loadyaypaypar() {
        dataAgent.loadYayPayPar();
    }

    public List<YayPayParVo> getYaypayparlist() {
        return yayPayParVoList;
    }

    public YayPayParVo getYaypayparById(String id) {
        for (YayPayParVo yayPayPar : yayPayParVoList) {
            if (yayPayPar.getId().equals(id))
                return yayPayPar;
        }

        return null;
    }

    public void notifyAttractionsLoaded(List<YayPayParVo> yayPayParVoList) {
        //Notify that the data is ready - using LocalBroadcast
        Log.e(YaePyayParApp.TAG, "notifyAttractionsLoaded: " );
        this.yayPayParVoList = yayPayParVoList;

        //keep the data in persistent layer.
        //YayPayParVo.saveAttractions(mAttractionList);

        //broadcastAttractionLoadedWithEventBus();
        //broadcastAttractionLoadedWithLocalBroadcastManager();
    }



}
