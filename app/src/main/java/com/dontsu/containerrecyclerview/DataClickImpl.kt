package com.dontsu.containerrecyclerview

class DataClickImpl (title: String, dataClickInterface: DataClickInterface) {

   init {
       dataClickInterface.onClickMemo(title)
   }

}