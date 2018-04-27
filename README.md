# ViewAndroid
自定义view的简单实现

实现自定义的方法（画个圆）

第一步、创建自定义View类（继承View）
public class SigeView extends View {
    private Paint mPaint;//初始化画笔

    public SigeView(Context context) {
        super(context);
    }

    // 第二个函数调用
    public SigeView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        //初始化画笔
        initView();
    }


    public SigeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    @SuppressLint("NewApi")
    public SigeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    private void initView() {
        mPaint = new Paint();
        mPaint.setColor(Color.RED);//设置画笔的颜色
        mPaint.setStrokeWidth(3f);//设置画笔的宽度
        mPaint.setStyle(Paint.Style.FILL);//充满
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 获取控件的高度和宽度

        //获取padding的大小
        final int paddingLeft = getPaddingLeft();
        final int paddingRight = getPaddingRight();
        final int paddingTop = getPaddingTop();
        final int paddingBottom = getPaddingBottom();
        //减去边距
        int width = getWidth() - paddingLeft -paddingRight;
        int height = getHeight() -paddingTop - paddingBottom;

        int r = Math.min(width, height)/2;
        canvas.drawCircle(paddingLeft+width/2,paddingTop+height/2,r,mPaint);
    }
}


第二步、MainActivity的xml

  <RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context="com.grant.view.MainActivity">

    <com.grant.view.SigeView
        android:layout_width="match_parent"
        android:layout_height="200dp"
        android:background="@android:color/holo_blue_bright"
        android:padding="20dp"/>

</RelativeLayout>

完成。
onMeasure（）的测量
layout的布局
onDraw（）的绘制


