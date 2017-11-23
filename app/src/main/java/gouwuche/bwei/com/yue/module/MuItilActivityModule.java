package gouwuche.bwei.com.yue.module;


import gouwuche.bwei.com.yue.MultiBean;
import gouwuche.bwei.com.yue.okhttp.AbstractUiCallBack;
import gouwuche.bwei.com.yue.okhttp.OkhttpUtils;

/**
 * Created by Adminjs on 2017/11/10.
 */
public class MuItilActivityModule {

    public void onRefresh(boolean up, final ModuleCallBack callBack) {


        OkhttpUtils.getInstance().asy(null, "http://tingapi.ting.baidu.com/v1/restserver/ting?method=baidu.ting.billboard.billList&type=1&size=10&offset=0", new AbstractUiCallBack<MultiBean>() {
            @Override
            public void success(MultiBean bean) {

                callBack.success(bean);
            }

            @Override
            public void failure(Exception e) {

                callBack.failure(e);
            }
        });


    }


    public  interface ModuleCallBack {
        public void success(MultiBean bean);
        public void failure(Exception bean);

    }


}