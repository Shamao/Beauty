# Beauty
1. DiagonalDrawable (refer to https://github.com/massivedisaster/DiagonalDrawable)

```
DiagonalDrawable.Builder builder = new DiagonalDrawable.Builder()
                .setStartColor(Color.parseColor("#E52878"))
                .setEndColor(Color.parseColor("#EE2A7B"))
                .setReverseLayout(true);
DiagonalDrawable drawable = builder.build();
```

2. AdaptiveDrawable 将bitmap 始终居中在Drawable中  可适应于加载图片时不同比例的占位图

```
Bitmap bitmap = BitmapFactory.decodeResource(holder.itemView.getContext().getResources(),R.drawable.gank_ph_meizi);
AdaptiveDrawable drawable = new AdaptiveDrawable(bitmap, 0, 0, Color.BLACK);
```

3. CommonLinearItemDecoration, 用来修饰RecyclerView LinearlayoutManager中的item之间和边缘的间隔
```
     /**
     * 构造 方法
     *
     * @param originPadding item之间的间隔大小 不包括边缘
     * @param orientation LinearLayoutManager的一致
     */
 public CommonLinearItemDecoration(int originPadding, int orientation) {
        mOriginPadding = originPadding;
        mOrientation = orientation;
    }
     /**
     *  设置边缘间隔大小
     *
     * @param verticalEdgePadding 垂直方向边缘上的间隔大小
     * @param horizontalEdgePadding  水平方向边缘上的间隔大小
     * @return
     */
    public CommonLinearItemDecoration withEdge(int verticalEdgePadding, int horizontalEdgePadding) {
        isIncludeEdge = true;
        mVerticalEdgePadding = verticalEdgePadding;
        mHorizontalEdgePadding = horizontalEdgePadding;
        return this;
    }
    
  RecyclerView.ItemDecoration mItemDecoration = 
  new CommonLinearItemDecoration(paddinging,LinearLayoutManager.VERTICAL)
  .withEdge(padding, pading);
```

###
```
 /**
     * @param originBitmap
     * @param padding
     * @return
     * @throws OutOfMemoryException
     */
    public static Bitmap getCircleBitmapFitOut(Bitmap originBitmap, int padding) throws OutOfMemoryException {
        if (originBitmap == null)
            return null;

        //获取原bitmap的长 宽 中心点 X Y
        int originWidth = originBitmap.getWidth();
        int originHeight = originBitmap.getHeight();
        int originCircleX = originBitmap.getWidth() / 2;
        int originCircleY = originBitmap.getHeight() / 2;
        //获取输出bitmap的大小和半径
        int outputSize = Math.min(originWidth, originHeight);
        int outputRadius = outputSize / 2;
        Bitmap output;
        try {
            output = Bitmap.createBitmap(outputSize, outputSize, Bitmap.Config.ARGB_8888);
        } catch (Exception | StackOverflowError e) {
            e.printStackTrace();
            output = null;
        } catch (OutOfMemoryError ex) {
            throw new OutOfMemoryException(ex.getMessage());
        }

        if (output == null)
            return null;

        Canvas canvas = new Canvas(output);
        // 计算原bitmap需要被绘制的区域
        int left = originCircleX - outputRadius;
        int top = originCircleY - outputRadius;
        int right = originCircleX + outputRadius;
        int bottom = originCircleY + outputRadius;
        Rect srcRect = new Rect(left, top, right, bottom);
        //计算canvas的绘制区域
        Rect desRect = new Rect(padding, padding, outputSize - padding, outputSize - padding);

        final int color = 0xff424242;
        final Paint paint = new Paint();
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(color);
        canvas.drawCircle(outputRadius, outputRadius, outputRadius, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(originBitmap, srcRect, desRect, paint);

        return output;
    }
```

