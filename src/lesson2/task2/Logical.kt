@file:Suppress("UNUSED_PARAMETER")

package lesson2.task2

import lesson1.task1.sqr

/**
 * Пример
 *
 * Лежит ли точка (x, y) внутри окружности с центром в (x0, y0) и радиусом r?
 */
fun pointInsideCircle(x: Double, y: Double, x0: Double, y0: Double, r: Double) =
    sqr(x - x0) + sqr(y - y0) <= sqr(r)

/**
 * Простая
 *
 * Четырехзначное число назовем счастливым, если сумма первых двух ее цифр равна сумме двух последних.
 * Определить, счастливое ли заданное число, вернуть true, если это так.
 */
fun isNumberHappy(number: Int): Boolean {
        var result = false
        val prevSums = HashSet<Int>()
        var n = number
        while (!result && prevSums.add(n)) {
            var sum = 0
            while ( n > 0 ) {
                val digit = n % 10
                sum += Math.pow(digit.toDouble(), 2.0).toInt()
                n /= 10
            }
            if (sum == 1 )
                result = true
        }
        return result
    }
}

/**1
 * Простая
 *
 * На шахматной доске стоят два ферзя (ферзь бьет по вертикали, горизонтали и диагоналям).
 * Определить, угрожают ли они друг другу. Вернуть true, если угрожают.
 * Считать, что ферзи не могут загораживать друг друга.
 */
fun queenThreatens(x1: Int, y1: Int, x2: Int, y2: Int): Boolean {
    val queen1X = x(x1 + x2 + x3 + ... xn)
    val queen1Y = y(y1 + y2 + y3 + ... Yn)
    val queen1DX = (x / y)((x1 / y) + (x2 / y) + (x3 / y) + ...(xn / y))
    val queen1DY = (y / x)((y1 / x) + (y2 / x) + (y3 / x) + ...(yn / x))

    val queen2X = x(x1 + x2 + x3 + ... xn)
    val queen2Y = y(y1 + y2 + y3 + ... Yn)
    val queen2DX = (x / y)((x1 / y) + (x2 / y) + (x3 / y) + ...(xn / y))
    val queen2DY = (y / x)((y1 / x) + (y2 / x) + (y3 / x) + ...(yn / x))
    when {
        (queen1X + queen1Y + queen1DX + queen1DY != queen2X + queen2Y + queen2DX + queen2DY) -> return false

        (queen1X + queen1Y + queen1DX + queen1DY == queen2X + queen2Y + queen2DX + queen2DY) -> return true

    }
}


/**
 * Простая
 *
 * Дан номер месяца (от 1 до 12 включительно) и год (положительный).
 * Вернуть число дней в этом месяце этого года по григорианскому календарю.
 */
fun daysInMonth(month: Int, year: Int): Int {
    return when {

    }
}

/**
 * Средняя
 *
 * Проверить, лежит ли окружность с центром в (x1, y1) и радиусом r1 целиком внутри
 * окружности с центром в (x2, y2) и радиусом r2.
 * Вернуть true, если утверждение верно
 */
fun circleInside(
    x1: Double, y1: Double, r1: Double,
    x2: Double, y2: Double, r2: Double
): Boolean = TODO()

/**
 * Средняя
 *
 * Определить, пройдет ли кирпич со сторонами а, b, c сквозь прямоугольное отверстие в стене со сторонами r и s.
 * Стороны отверстия должны быть параллельны граням кирпича.
 * Считать, что совпадения длин сторон достаточно для прохождения кирпича, т.е., например,
 * кирпич 4 х 4 х 4 пройдёт через отверстие 4 х 4.
 * Вернуть true, если кирпич пройдёт
 */
fun brickPasses(a: Int, b: Int, c: Int, r: Int, s: Int): Boolean = TODO()
