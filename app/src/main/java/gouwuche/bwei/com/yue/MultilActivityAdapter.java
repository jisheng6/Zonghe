package gouwuche.bwei.com.yue;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Adminjs on 2017/11/10.
 */
public class MultilActivityAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<MultiBean.SongListBean> list;

    public MultilActivityAdapter(Context context) {
        this.context = context;
        ImageLoader.getInstance().init(ImageLoaderConfiguration.createDefault(context));
    }

    public void addData(List<MultiBean.SongListBean> list) {
        if (this.list == null) {
            this.list = new ArrayList<>();
        }
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view1 = LayoutInflater.from(context).inflate(R.layout.item1, parent, false);
        return new ViewHolder1(view1);


    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewHolder1) {
            ViewHolder1 holder1 = (ViewHolder1) holder;


            holder1.listItem1Textview.setText(list.get(position).getTitle());
            holder1.anme.setText(list.get(position).getArtist_name());
            ImageLoader.getInstance().displayImage(list.get(position).getPic_radio(), holder1.listItem1Imageview);
            ((ViewHolder1) holder).listItem1Imageview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context,"点击",Toast.LENGTH_SHORT).show();
                }
            });

        }
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    static class ViewHolder1 extends RecyclerView.ViewHolder {
        @Bind(R.id.list_item1_imageview)
        ImageView listItem1Imageview;
        @Bind(R.id.list_item1_textview)
        TextView listItem1Textview;
        @Bind(R.id.name)
        TextView anme;
        public ViewHolder1(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
