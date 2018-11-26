package com.javatpoint.user.foodie.fragment;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.javatpoint.user.foodie.R;

class CustomListviewForOrder extends ArrayAdapter {

    private String[] Date;
    private String[] Status;
    private String[] OrderNumber;
    private String[] OrderPrice;
    private Activity context;



    public CustomListviewForOrder(Activity context,String[] Date,String[] Status,String[] OrderNumber,String[] OrderPrice)
    {
        super(context, R.layout.order_listview_row,Date);

        this.context=context;
        this.Date=Date;
        this.Status=Status;
        this.OrderNumber=OrderNumber;
        this.OrderPrice=OrderPrice;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        View r=convertView;
        ViewHolder viewHolder=null;
        if(r==null)
        {
            LayoutInflater layoutInflater=context.getLayoutInflater();
            r=layoutInflater.inflate(R.layout.order_listview_row,null,true);
            viewHolder=new ViewHolder(r);
            r.setTag(viewHolder);
        }
        else
        {
            viewHolder=(ViewHolder) r.getTag();
        }

        viewHolder.date.setText(Date[position]);
        viewHolder.status.setText(Status[position]);
        viewHolder.orderNumber.setText(OrderNumber[position]);
        viewHolder.orderPrice.setText(OrderPrice[position]);

        return r;
    }

    class ViewHolder
    {
        TextView date;
        TextView status;
        TextView orderNumber;
        TextView orderPrice;
        ViewHolder(View v)
        {
            date=v.findViewById(R.id.textViewDate);
            status=v.findViewById(R.id.textViewStatus);
            orderNumber=v.findViewById(R.id.textViewNumber);
            orderPrice=v.findViewById(R.id.textViewPrice1);
        }
    }
}
