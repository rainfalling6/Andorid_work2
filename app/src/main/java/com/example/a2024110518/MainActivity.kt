package com.example.a2024110518

import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

/**
 * 控制器层（Controller）：
 *  - 区1：响应按钮点击，动态向 ScrollView 内的 LinearLayout 添加 TextView
 *  - 区2：响应专业按钮点击，查询 Model 并把结果显示到 TextView
 */
class MainActivity : AppCompatActivity() {

    /** 区1 已添加的 TextView 计数 */
    private var count = 0

    /** 模型层实例 */
    private val adviser = ProgramAdviser()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initArea1()
        initArea2()
    }

    /** 区1：按钮点击 -> 动态添加一个编号 TextView */
    private fun initArea1() {
        val container = findViewById<LinearLayout>(R.id.containerTextViews)
        findViewById<Button>(R.id.btnAdd).setOnClickListener {
            count++
            val tv = TextView(this).apply {
                text = getString(R.string.dynamic_tv_format, count)
                textSize = 16f
                setPadding(24, 24, 24, 24)
            }
            container.addView(tv)
        }
    }

    /** 区2：专业按钮点击 -> 查询模型层 -> 显示结果 */
    private fun initArea2() {
        val tvResult = findViewById<TextView>(R.id.tvResult)
        val programButtons = listOf(
            R.id.btnProgram1 to 0,
            R.id.btnProgram2 to 1,
            R.id.btnProgram3 to 2,
            R.id.btnProgram4 to 3
        )
        for ((buttonId, index) in programButtons) {
            findViewById<Button>(buttonId).setOnClickListener {
                tvResult.text = adviser.query(index)
            }
        }
    }
}
