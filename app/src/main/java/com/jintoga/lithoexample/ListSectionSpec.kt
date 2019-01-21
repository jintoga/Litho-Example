package com.jintoga.lithoexample

import android.graphics.Color
import android.widget.LinearLayout.HORIZONTAL
import com.facebook.litho.annotations.FromEvent
import com.facebook.litho.annotations.OnEvent
import com.facebook.litho.sections.Children
import com.facebook.litho.sections.SectionContext
import com.facebook.litho.sections.annotations.GroupSectionSpec
import com.facebook.litho.sections.annotations.OnCreateChildren
import com.facebook.litho.sections.common.DataDiffSection
import com.facebook.litho.sections.common.RenderEvent
import com.facebook.litho.sections.common.SingleComponentSection
import com.facebook.litho.sections.widget.ListRecyclerConfiguration
import com.facebook.litho.sections.widget.RecyclerCollectionComponent
import com.facebook.litho.widget.ComponentRenderInfo
import com.facebook.litho.widget.RenderInfo
import com.facebook.litho.widget.SnapUtil.SNAP_TO_CENTER


@GroupSectionSpec
object ListSectionSpec {

    @OnCreateChildren
    fun onCreateLayout(sectionContext: SectionContext): Children =
        Children.create()
            .child(
                SingleComponentSection.create(sectionContext)
                    .component(
                        RecyclerCollectionComponent.create(sectionContext)
                            .disablePTR(true)
                            .recyclerConfiguration(
                                ListRecyclerConfiguration.create()
                                    .orientation(HORIZONTAL)
                                    .snapMode(SNAP_TO_CENTER)
                                    .reverseLayout(false)
                                    .build()
                            )
                            .section(
                                DataDiffSection.create<Int>(sectionContext)
                                    .data(generateData(32))
                                    .renderEventHandler(ListSection.onRender(sectionContext))
                                    .build()
                            )
                            .canMeasureRecycler(true)
                    ).build()
            )
            .child(
                DataDiffSection.create<Int>(sectionContext)
                    .data(generateData(32))
                    .renderEventHandler(ListSection.onRender(sectionContext))
            )
            .build()

    @OnEvent(RenderEvent::class)
    fun onRender(sectionContext: SectionContext, @FromEvent model: Int): RenderInfo =
        ComponentRenderInfo.create()
            .component(
                ListItem
                    .create(sectionContext)
                    .color(if (model % 2 == 0) Color.WHITE else Color.LTGRAY)
                    .title("$model. Hello, world!")
                    .subtitle("Litho tutorial")
                    .build()
            )
            .build()

    private fun generateData(count: Int): List<Int> {
        val data = ArrayList<Int>(count)
        for (i in 0 until count) {
            data.add(i)
        }
        return data
    }
}