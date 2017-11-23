package gouwuche.bwei.com.yue;


import gouwuche.bwei.com.yue.module.MuItilActivityModule;

/**
 * Created by muhanxi on 17/11/10.
 */

public class MultilActivityPresenter {


    private MultiView view;
    private MuItilActivityModule multilActivityModule ;

    public MultilActivityPresenter(MultiView view){
        this.view = view;
        this.multilActivityModule = new MuItilActivityModule();
    }


    /**
     * 下啦刷新
     */
    public void onRefresh(boolean up) {

        multilActivityModule.onRefresh(up, new MuItilActivityModule.ModuleCallBack() {
            @Override
            public void success(MultiBean bean) {
                view.success(bean);
            }

            @Override
            public void failure(Exception e) {

                view.failure(e);
            }
        });

    }


}
