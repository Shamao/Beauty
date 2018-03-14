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
