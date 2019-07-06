https://developer.android.com/jetpack
JetPack是Android官方在2018年发布的一套库组合，包括基础、构架、行为、界面4大类，每类下有若干组件。想开发App享用这套组件库，在创建app界面时选上 User androidx.\* artifacts选项

ViewModel、LiveData、Databinding都是界面数据及状态管理最常用到的组件

ViewModel的初始化(viewModel继承自androidx.lifecycle.ViewModel)：
```
viewModel = ViewModelProviders.of(this).get(CounterViewModel.class);
```
想要用ViewModelProviders类，要在gradle的dependencies上这句：
```
implementation 'androidx.lifecycle:lifecycle-extensions:2.0.0'
```
ViewModel+LiveData很方便实现MVVM


在gradle的defaultConfig以下这句，syncing
```
dataBinding {
    enabled true
}
```
在界面的xml文件上选中第一行会出现一个小黄灯，点击它选 Convert to data binding layout，在xml的外面加了一个标签layout，在layout下加了一个标签data，这样在对应的Activity类就多了一个对象类型，如ActivityMainBinding（界面类为MainActivity）
```
ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
```
把默认的setContentView注释掉，用下面一句初始化binding，这样就可以用binding.xxx（xxx为控件的id），省掉了在Activity中定义繁多的控件及写繁多的findViewById(R.xx.xxx)这样的代码了，这个流程就是把界面控件绑定到binding对象中，还有一种什么作法是把数据回绑到界面控件，具体做法是在data标签下：
```
<data>
    <variable
        name="vm"
        type="com.dvs.basketballcounter.CounterViewModel" />
</data>
...
// TextView标签下这样写
android:text="@{String.valueOf(vm.number)}"
...
// Button标签下这样写
android:onClick="@{()->vm.add()}"
```
且要在Activity类的onCreate中加上这两句：
```
binding.setVm(viewModel);
binding.setLifecycleOwner(this);
```

######这样的回绑定方式是可以少写些数据监听与事件方法，但对线上代码问题的排查不利。



参考：https://www.bilibili.com/video/av54245034