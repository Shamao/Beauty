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

