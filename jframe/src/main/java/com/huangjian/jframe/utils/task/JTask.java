package com.huangjian.jframe.utils.task;

import android.os.AsyncTask;

import java.util.List;

/**
 * Description: 对AsyncTask简单封装
 * Author: huangjian
 * Date: 16/3/9 下午1:44.
 */
public class JTask extends AsyncTask<Void, Integer, Object> {

    private TaskItem taskItem;

    /**
     * 初始化Task.
     */
    public JTask(TaskItem taskItem) {
        super();
        this.taskItem = taskItem;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        TaskCallback callback = this.taskItem.getCallback();
        if (callback != null) {
            callback.prepare();
        }
    }

    /**
     *
     * 执行任务.
     * @return
     */
    @Override
    protected Object doInBackground(Void... voids) {
        TaskCallback callback = this.taskItem.getCallback();
        if (callback != null) {
            return callback.execute();
        }
        return null;
    }

    /**
     *
     * 执行完成.
     * @param result
     */
    @Override
    protected void onPostExecute(Object result) {
        TaskCallback callback = this.taskItem.getCallback();
        if (callback != null) {
            callback.update(result);
        }
    }
}
