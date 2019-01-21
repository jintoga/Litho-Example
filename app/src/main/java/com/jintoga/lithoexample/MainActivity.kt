package com.jintoga.lithoexample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.facebook.litho.ComponentContext
import com.facebook.litho.LithoView
import com.facebook.litho.sections.SectionContext
import com.facebook.litho.sections.widget.RecyclerCollectionComponent

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val context = ComponentContext(this)

        val component = RecyclerCollectionComponent
            .create(context)
            .disablePTR(true)
            .section(ListSection.create(SectionContext(context)).build())
            .build()

        setContentView(LithoView.create(context, component))
    }
}
