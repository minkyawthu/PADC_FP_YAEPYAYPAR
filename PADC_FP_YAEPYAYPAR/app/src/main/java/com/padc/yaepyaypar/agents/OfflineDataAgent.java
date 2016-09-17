package com.padc.yaepyaypar.agents;

import android.util.Log;

import com.google.gson.reflect.TypeToken;
import com.padc.yaepyaypar.Utils.CommonInstances;
import com.padc.yaepyaypar.Utils.JsonUtils;
import com.padc.yaepyaypar.model.YaypayparModel;
import com.padc.yaepyaypar.vos.YayPayParVo;

import org.json.JSONException;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by kaungkhantthu on 9/17/16.
 */
public class OfflineDataAgent implements YayPayParDataAgent {
    private static final String OFFLINE_ATTRACTION_LIST = "sample.json";

    private static OfflineDataAgent objInstance;

    private OfflineDataAgent() {

    }

    public static OfflineDataAgent getInstance() {
        if (objInstance == null) {
            objInstance = new OfflineDataAgent();
        }

        return objInstance;
    }

    @Override
    public void loadAttractions() {
        try {
            String attractions = JsonUtils.getInstance().loadDummyData(OFFLINE_ATTRACTION_LIST);
            Type listType = new TypeToken<List<YayPayParVo>>() {
            }.getType();
            List<YayPayParVo> YaypayparList = CommonInstances.getGsonInstance().fromJson(attractions, listType);
            Log.e( "loadyaypaypar: ",YaypayparList.toString() );
           YaypayparModel.getInstance().notifyAttractionsLoaded(YaypayparList);
            return;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
