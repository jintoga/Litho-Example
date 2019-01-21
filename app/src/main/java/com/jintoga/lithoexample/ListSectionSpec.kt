package com.jintoga.lithoexample

import android.graphics.Color
import com.facebook.litho.sections.Children
import com.facebook.litho.sections.SectionContext
import com.facebook.litho.sections.annotations.GroupSectionSpec
import com.facebook.litho.sections.annotations.OnCreateChildren
import com.facebook.litho.sections.common.SingleComponentSection


@GroupSectionSpec
object ListSectionSpec {

    @OnCreateChildren
    fun onCreateLayout(sectionContext: SectionContext): Children {
        val builder = Children.create()
        for (i in 0..31) {
            val listItem = ListItem
                .create(sectionContext)
                .color(if (i % 2 == 0) Color.WHITE else Color.LTGRAY)
                .title("$i. Hello, world!")
                .subtitle("Litho tutorial")
                .build()
            builder.child(
                SingleComponentSection.create(sectionContext)
                    .key(i.toString())
                    .component(listItem)
            )
        }
        return builder.build()
    }
}