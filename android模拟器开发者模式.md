开发者选项有很多有用的工具，帮助调试和监控开发的app
Settings——>System——>Developer options
若在System中找不到Developer options，开启方法：
Settings——>System——>About elulated device——>Build number，点击Build number 7次，返回就看到 Developer options了

比如在App分组下的开启Don't keep activities，使app在切换到后面时，destroy掉activity，这对ViewModel的状态保持的调试很有用