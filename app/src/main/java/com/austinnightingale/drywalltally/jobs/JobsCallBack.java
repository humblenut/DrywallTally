package com.austinnightingale.drywalltally.jobs;

import android.support.v4.app.DialogFragment;

public interface JobsCallBack {

    void openFragment(DialogFragment fragment);

    void openJobActivity(int jobID, String name);
}
