package tw.android;

import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

public class Main extends Activity {
	private TextView tvDate, tvTime;
	private Button btDate, btTime;
	private int mYear, mMonth, mDay, mHour, mMinute;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		tvDate = (TextView) findViewById(R.id.tvDate);
		tvTime = (TextView) findViewById(R.id.tvTime);

		btDate = (Button) findViewById(R.id.btDate);
		btTime = (Button) findViewById(R.id.btTime);

		btDate.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				showDatePickerDialog();
			}
		});
		btTime.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				showTimePickerDialog();
			}
		});
	}

	public void showDatePickerDialog() {
		// 設定初始日期
		final Calendar c = Calendar.getInstance();
		mYear = c.get(Calendar.YEAR);
		mMonth = c.get(Calendar.MONTH);
		mDay = c.get(Calendar.DAY_OF_MONTH);

		// 跳出日期選擇器
		DatePickerDialog dpd = new DatePickerDialog(this,
				new DatePickerDialog.OnDateSetListener() {
					public void onDateSet(DatePicker view, int year,
							int monthOfYear, int dayOfMonth) {
						// 完成選擇，顯示日期
						tvDate.setText(year + "-" + (monthOfYear + 1) + "-"
								+ dayOfMonth);

					}
				}, mYear, mMonth, mDay);
		dpd.show();
	}

	public void showTimePickerDialog() {
		// 設定初始時間
		final Calendar c = Calendar.getInstance();
		mHour = c.get(Calendar.HOUR_OF_DAY);
		mMinute = c.get(Calendar.MINUTE);

		// 跳出時間選擇器
		TimePickerDialog tpd = new TimePickerDialog(this,
				new TimePickerDialog.OnTimeSetListener() {
					public void onTimeSet(TimePicker view, int hourOfDay,
							int minute) {
						// 完成選擇，顯示時間
						tvTime.setText(hourOfDay + ":" + minute);
					}
				}, mHour, mMinute, false);
		tpd.show();
	}

}