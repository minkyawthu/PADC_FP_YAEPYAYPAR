package com.padc.yaepyaypar.model;

import com.padc.yaepyaypar.agents.OfflineDataAgent;
import com.padc.yaepyaypar.agents.YayPayParDataAgent;

/**
 * Created by kaungkhantthu on 9/17/16.
 */
public abstract class BaseModel {

    private static final int INIT_DATA_AGENT_OFFLINE = 1;
    private static final int INIT_DATA_AGENT_RETROFIT = 4;

    protected YayPayParDataAgent dataAgent;

    public BaseModel() {
        initDataAgent(INIT_DATA_AGENT_OFFLINE);


    }

    private void initDataAgent(int initType) {
        switch (initType) {
            case INIT_DATA_AGENT_OFFLINE:
                dataAgent = OfflineDataAgent.getInstance();
                break;

            case INIT_DATA_AGENT_RETROFIT:
               // dataAgent = RetrofitDataAgent.getInstance();
                break;
        }
    }

    public void onEventMainThread(Object obj) {

    }
}
