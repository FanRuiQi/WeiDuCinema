package com.bw.movie.cinema.fragment.activity;

import android.widget.TextView;

import com.bw.movie.R;
import com.bw.movie.base.BaseActivity;
import com.bw.movie.bean.CinemaSeatTableDetailBean;
import com.bw.movie.custom.SeatTable;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Author: 范瑞旗
 * Date: 2019/1/28 10:33
 * Description: 选座-Activity
 */
public class CinemaSeatTableActivity extends BaseActivity {

    @BindView(R.id.cinema_seat_table_text_beginTime)
    TextView mTextView_beginTime;

    @BindView(R.id.cinema_seat_table_text_endTime)
    TextView mTextView_endTime;

    @BindView(R.id.cinema_seat_table_text_hall)
    TextView mTextView_hall;

    public SeatTable seatTableView;
    @Override
    public void initView() {

    }

    @Override
    public void initData() {
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);

        seatTableView = (SeatTable) findViewById(R.id.seatView);
        seatTableView.setScreenName("8号厅荧幕");//设置屏幕名称
        seatTableView.setMaxSelected(3);//设置最多选中

        seatTableView.setSeatChecker(new SeatTable.SeatChecker() {

            @Override
            public boolean isValidSeat(int row, int column) {
                if(column==2) {
                    return false;
                }
                return true;
            }

            @Override
            public boolean isSold(int row, int column) {
                if(row==6&&column==6){
                    return true;
                }
                return false;
            }

            @Override
            public void checked(int row, int column) {


            }

            @Override
            public void unCheck(int row, int column) {

            }

            @Override
            public String[] checkedSeatTxt(int row, int column) {
                return null;
            }

        });
        seatTableView.setData(10,15);

    }

    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
    public void sjx(CinemaSeatTableDetailBean detailsBean){

        mTextView_beginTime.setText(detailsBean.getBeginTime());
        mTextView_endTime.setText(detailsBean.getEndTime());
        mTextView_hall.setText(detailsBean.getHall());
        int seatsTotal = detailsBean.getSeatsTotal();

    }

    @Override
    public int getContent() {
        return R.layout.activity_cinema_seat_table;
    }

    @Override
    public void success(Object data) {

    }

    @Override
    public void fail(String error) {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
