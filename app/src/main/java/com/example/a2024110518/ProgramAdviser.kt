package com.example.a2024110518

/**
 * 模型层的数据实体：一个专业。
 */
data class Program(
    val code: String,
    val name: String,
    val hours: Int,
    val credits: Int
)

/**
 * 模型层（Model）：保存专业数据，对外提供查询接口。
 * 不依赖任何 Android 组件，可独立进行单元测试。
 */
class ProgramAdviser {

    private val programs = listOf(
        Program("SE", "软件工程", 3200, 160),
        Program("CS", "计算机科学", 3100, 155),
        Program("NE", "网络工程", 3000, 150),
        Program("AI", "人工智能", 3300, 165)
    )

    /** 专业总数，供控制器/测试使用。 */
    val size: Int get() = programs.size

    /**
     * 根据索引查询专业信息。
     * @param index 专业索引（从 0 开始）
     * @return 格式化后的专业信息；索引越界时返回提示文本
     */
    fun query(index: Int): String {
        val program = programs.getOrNull(index) ?: return "未找到对应专业"
        return "专业代码：${program.code}\n" +
            "专业名称：${program.name}\n" +
            "总学时：${program.hours}\n" +
            "总学分：${program.credits}"
    }
}
