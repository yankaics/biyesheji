package com.zhicall.hax.activities;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.SectionIndexer;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.zhicall.hax.R;
import com.zhicall.hax.bean.Contact;
import java.util.List;

/**
 * Created by Xingchen on 2015/12/9.
 * Email:huangjinxin@zhicall.cn
 */
public class ListViewWithSeekActivity extends Activity implements View.OnTouchListener {
  @Bind(R.id.tv_test) TextView mTextView;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_listviewwithseekbar);
    ButterKnife.bind(this);
    mTextView.setOnTouchListener(this);
  }

  @Override public boolean onTouch(View v, MotionEvent event) {

    Log.i("pos", "X=" + event.getX() + "  Y=" + event.getY());
    return false;
  }
  public static class SeekBarListViewAdpater  extends BaseAdapter implements SectionIndexer {

    private List<Contact> list = null;
    private Context mContext;

    public SeekBarListViewAdpater(Context mContext, List<Contact> list) {
      this.mContext = mContext;
      this.list = list;
    }

    /**
     * 当ListView数据发生变化时,调用此方法来更新ListView
     * @param list
     */
    public void updateListView(List<Contact> list){
      this.list = list;
      notifyDataSetChanged();
    }

    public int getCount() {
      return this.list.size();
    }

    public Object getItem(int position) {
      return list.get(position);
    }

    public long getItemId(int position) {
      return position;
    }


    @Override
    public View getView(final int position, View view, ViewGroup arg2) {
      ViewHolder viewHolder = null;
      final Contact mContent = list.get(position);
      if (view == null) {
        viewHolder = new ViewHolder();
        view = LayoutInflater.from(mContext).inflate(R.layout.item, null);
        viewHolder.tvTitle = (TextView) view.findViewById(R.id.title);
        viewHolder.tvLetter = (TextView) view.findViewById(R.id.catalog);
        view.setTag(viewHolder);
      } else {
        viewHolder = (ViewHolder) view.getTag();
      }

      //根据position获取分类的首字母的char ascii值
      int section = getSectionForPosition(position);

      //如果当前位置等于该分类首字母的Char的位置 ，则认为是第一次出现
      if(position == getPositionForSection(section)){
        viewHolder.tvLetter.setVisibility(View.VISIBLE);
        viewHolder.tvLetter.setText(mContent.getFirstLetter());
      }else{
        viewHolder.tvLetter.setVisibility(View.GONE);
      }

      viewHolder.tvTitle.setText(this.list.get(position).getName());

      return view;

    }

    final static class ViewHolder {
      TextView tvLetter;
      TextView tvTitle;
    }


    /**
     * 根据ListView的当前位置获取分类的首字母的char ascii值
     */
    public int getSectionForPosition(int position) {
      return list.get(position).getFirstLetter().charAt(0);
    }

    /**
     * 根据分类的首字母的Char ascii值获取其第一次出现该首字母的位置
     */
    public int getPositionForSection(int section) {
      for (int i = 0; i < getCount(); i++) {
        String sortStr = list.get(i).getFirstLetter();
        char firstChar = sortStr.toUpperCase().charAt(0);
        if (firstChar == section) {
          return i;
        }
      }

      return -1;
    }


    @Override
    public Object[] getSections() {
      return null;
    }
  }
}
