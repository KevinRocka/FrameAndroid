#Android MVC MVP MVVM解析

## MVC (Model-View-Controller)

* Model：数据的获取方式(通过缓存，通过网络，通过本地文件等)以及javabean
* View：控制数据的展示方式(xml文件)和自定义view
* Controller：Model和View层的交互从Model获取完数据，返回给View。在MVC中通常是Activity


概述：如果要动态的修改某个按钮的状态可见或者不可见，如果不是使用自定义view，那就只有在Activity中控制，造成Activity即是View层，又是Controller层，代码显得过于臃肿，耦合度太高。	



## MVP (Model-View-Presenter)
* Model 数据的获取方式(通过缓存，通过网络，通过本地文件等)以及javabean
* View  就是纯粹的Activity和Fragment
* Presenter Activity中的UI逻辑抽象成View接口，把业务逻辑抽象成Presenter接口

概述：view层和model层完全解耦，presenter充当桥梁，presenter层去操作model层，并且将数据返回给view层



## MVVM (Model-View-ViewModel)（DataBinding）
* Model 数据的获取方式(通过缓存，通过网络，通过本地文件等)为ViewModel提供数据
* View Activity，Fragment，Dialog之类都属于View层
* ViewModel 逻辑控制层，负责处理数据和处理View层中的业务逻辑

概述：DataBinding应该是作为一个绑定器用于绑定实体类与View层，而我们的业务逻辑和View的控制应该抽象我们的ViewModel层中，可以实现视图和逻辑代码的解耦。






