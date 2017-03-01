#命名规范

###包的命名
**全部小写，并由按功能分包，域名定义**
###类的命名
**采用大驼峰命名法，每个单词首字母大写，尽量不用缩写**

类				| 描述  				 | 例如
----------  	| ------------- 	 | ------------
Activity类     	| 用Activity为后缀 	 | HelloActivity
Adapter类     	| 用Adapter为后缀	     | productListAdapter
Fragment类		| 用Fragmemt后缀       | HelloFragment
Model类          | 用m前缀和Model作为后缀 |  UserModel
自定义View类      | 用UI前缀和View后缀     |  UIExpandView
基础类            |用Base开头           |  BaseActivity
Listener类       |On前缀Listener后缀 | OnClickListener


###方法的命名
**采用小驼峰命名法，如：onClick() 动词+名词的/介词+名词**
方法 | 说明
--- | ----
initXX()| 初始化相关方法
isXX(), checkXX() | 方法返回boolean
getXX() | 返回某个值的方法
displayXX()|弹出提示框和提示信息，使用display为前缀标识
saveXX()|与保存数据相关的，使用save前缀标识
resetXX()|对数据重组的，使用reset前缀标识
clearXX()|清除数据相关的
removeXXX() |清除数据相关的
drawXXX()| 绘制数据或效果相关的
onXXX()|自定义点击事件



###变量的命名
**采用小驼峰命名法，类的成员变量以m开头，其他以小写开头，如：mProductList**

*避免用Flag来命名状态变量，使用Is来命名，例如：mIsLogin

其中控件命名加上控件类型对应缩写的后缀，例如：mUserNmaeTv

控件			| 缩写  	|示例			 |
----------  	| ------------- |-------
ViewGroup  	    | view 	        |mBlackView
TextView		| Tv			|mBlackTv
Button			| Btn			|mBlackBtn
ImageBtn		| ImgBtn		|mBlackImgbtn
ImageView		| ImgView/iv	|mBlackIv
CheckBox		| Chk/Cb		|mBlackCb
RadioButton		| RdoBtn/Rb		|mBlackRb
EditText		| edtTxt/edit   |mBlackEdit
ProgressBar		| proBar		|mBlackProBar
SeekBar 		| skBar		   	|
ListView		| lv            |mBlackLv
ScollView		| sclVi/scroll	|mBlackScroll


###资源文件命名（drawable文件夹下）
**全部小写，采用下划线**

类型             | 描述          | 示例
----            |  ----        |---
ic              | 普通图        | ic_logo
bg              | 背景图        | bg_logo
divider         | 分割图        | divider_logo
round           | 圆型          | round_logo
rect_round      | 圆角          | rect_round_loho
rect_rouund_    | l t b t圆角   | rect_round_lb_logo
select          | 选中状态图片    | select_logo



后缀        | 描述          | 示例
----        | ----          |---
nor         | 普通状态      |ic_logo_nor
hl          | 高亮状态      |ic_logo_hl
pressed     | 按下状态      |ic_logo_pressed
selected    | 选中状态      |ic_logo_selected
unselect    | 未选中状态    |ic_logo_unselect


###资源布局文件（layout）
**全部采用小写，采用下划线命名法**

| 类型             |  描述             | 示例|
|:---|:---:|---:|
|activity布局      | activity_属性     |activity_bbs_detail|
|fragment         | fragment_属性     |fragment_bbs_detail|
|列表的item         | item_属性         |item_brand|
|头尾布局           |header/footer_属性 |header_bbs_detail|
|自定义容器         |layout_属性        |layout_opt|
|自定义Widget      |Widget_属性         |widget_reward|
|toast            |toast_            |toast_view|
|popupwindow      |popup_            |popup_reward|
|dialog           |dialog_           |dialog_reward|

###动画文件（anim）（待定）
**全部采用小写， 下划线命名法， 加前缀区分**

前缀 | 说明
----|---
fade_in | 淡入
fade_out | 淡出
slide_in_left | 左边滑入
slide_out_left | 右边滑出
push | 代表没有选中状态


###id命名
类型            |  描述             | 示例
---            |---               |---
根布局id         |root_layout       |
其余容器         |layout_           |layout_black
自定义View       |View              |view_black
TextView       | tv_属性           |tv_skip
ImageView      | iv_属性           |iv_skip
ViewPager      | pager            |pager
RecyclerView   |Recycler          |recycler


###颜色值命名和尺寸命名(交给UI负责 有一个标准表)
###字符串资源（String）
**不需要与title、dialog、button等关联起来，直接使用相同语义或功能的英文，如：**
\<string name="ok">确定\</string>
\<string name=" welcome_to_use">欢迎使用\</string>






