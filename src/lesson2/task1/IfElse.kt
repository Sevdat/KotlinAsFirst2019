@file:Suppress("UNUSED_PARAMETER")

package lesson2.task1

import lesson1.task1.discriminant
import lesson1.task1.sqr
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.sqrt

/**
 * Пример
 *
 * Найти число корней квадратного уравнения ax^2 + bx + c = 0
 */
fun quadraticRootNumber(a: Double, b: Double, c: Double): Int {
    val discriminant = discriminant(a, b, c)
    return when {
        discriminant > 0.0 -> 2
        discriminant == 0.0 -> 1
        else -> 0
    }
}

/**
 * Пример
 *
 * Получить строковую нотацию для оценки по пятибалльной системе
 */
fun gradeNotation(grade: Int): String = when (grade) {
    5 -> "отлично"
    4 -> "хорошо"
    3 -> "удовлетворительно"
    2 -> "неудовлетворительно"
    else -> "несуществующая оценка $grade"
}

/**
 * Пример
 *
 * Найти наименьший корень биквадратного уравнения ax^4 + bx^2 + c = 0
 */
fun minBiRoot(a: Double, b: Double, c: Double): Double {
    // 1: в главной ветке if выполняется НЕСКОЛЬКО операторов
    if (a == 0.0) {
        if (b == 0.0) return Double.NaN // ... и ничего больше не делать
        val bc = -c / b
        if (bc < 0.0) return Double.NaN // ... и ничего больше не делать
        return -sqrt(bc)
        // Дальше функция при a == 0.0 не идёт
    }
    val d = discriminant(a, b, c)   // 2
    if (d < 0.0) return Double.NaN  // 3
    //
    val y1 = (-b + sqrt(d)) / (2 * a)
    val y2 = (-b - sqrt(d)) / (2 * a)
    val y3 = max(y1, y2)       // 5
    if (y3 < 0.0) return Double.NaN // 6
    return -sqrt(y3)           // 7
}

/**
 * Простая
 *
 * Мой возраст. Для заданного 0 < n < 200, рассматриваемого как возраст человека,
 * вернуть строку вида: «21 год», «32 года», «12 лет».
 */
fun ageDescription(age: Int): String {
    if (age in 1..20) {
        when {
            (age in 2..4) -> return ("$age года")
            (age in 5..20) -> return ("$age лет")
            (age == 1) -> return ("$age год")
        }
    }
    if (age in 21..99) {
        when {
            (age % 10 in 2..4) -> return ("$age года")
            (age % 10 in 5..9) -> return ("$age лет")
            (age % 10 == 1) -> return ("$age год")
        }
    }
    if (age in 100..120) {
        when {
            (age % 100 in 2..4) -> return ("$age года")
            (age % 100 in 5..20) -> return ("$age лет")
            (age % 10 == 1) -> return ("$age год")
        }
    }
    if (age in 121..200) {
        when {
            (age % 10 in 2..4) -> return ("$age года")
            (age % 10 in 5..9) -> return ("$age лет")
            (age == 1) -> return ("$age год")
        }
    }
    return ("")
}


//(age in 1..20)
//if (age == 1) return ("$age год")
//if (age in 2..4) return ("$age года")
//if (age in 5..20) return ("$age лет")

//(age in 21..99)
//if (age % 10 == 1) return ("$age год")
//if (age in 21..99) return ("$age года")

//(age in 100..121)
//if (age % 100 == 1) return ("$age год")
//if (age % 100 in 2..4) return ("$age года")
//if (age % 100 in 5..20) return ("$age лет")

//(age in 121..200)
//if (age % 100 == 1) return ("$age год")
//if (age in 121..200) return ("$age года")
//else return ("$age года")
//}
//else when (age in 21..99) {
//  (age % 10 == 1) -> return ("$age год")
//   (age % 10 <= 2 && age % 10 >= 4) -> return ("$age года")
//  (age % 10 <= 5 && age % 10 >= 20) -> return ("$age лет")
// (age in 1..200)

//   return when (age in 1..99) {
//     (age % 10 == 1) -> ("$age год")
//   (age <= 2 && age % 10 >= 3) -> ("$age года")
// (age % 10 <= 4 && age % 10 >= 20) -> ("$age лет")
// else -> {
//   return when (age in 100..200) {
// (age % 100 == 1) -> ("$age год")
//(age % 100 <= 2 && age % 100 >= 3) -> ("$age года")
//(age % 100 <= 4 && age % 100 >= 20) -> ("$age лет")
//   else -> ("года")
// }
//   }
//}
//  }
/**
 * Простая
 *
 * Путник двигался t1 часов со скоростью v1 км/час, затем t2 часов — со скоростью v2 км/час
 * и t3 часов — со скоростью v3 км/час.
 * Определить, за какое время он одолел первую половину пути?
 */
fun timeForHalfWay(
    t1: Double, v1: Double,
    t2: Double, v2: Double,
    t3: Double, v3: Double
): Double {
    val forHalfDist = (v1 * t1 + v2 * t2 + v3 * t3) / 2
    when {
        (forHalfDist <= v1 * t1) -> (forHalfDist / v1)
    (forHalfDist <= (v1 * t1 + v2 * t2)) -> (forHalfDist - v1 * t1) / (v2 + t1)
        else -> (forHalfDist - (v1 * t1 + v2 * t2)) / (v3 + t1 + t2)
}
    return 0.0
}
/**
 * Простая
 *
 * Нa шахматной доске стоят черный король и две белые ладьи (ладья бьет по горизонтали и вертикали).
 * Определить, не находится ли король под боем, а если есть угроза, то от кого именно.
 * Вернуть 0, если угрозы нет, 1, если угроза только от первой ладьи, 2, если только от второй ладьи,
 * и 3, если угроза от обеих ладей.
 * Считать, что ладьи не могут загораживать друг друга
 */
fun whichRookThreatens(
    kingX: Int, kingY: Int,
    rookX1: Int, rookY1: Int,
    rookX2: Int, rookY2: Int
): Int =
    when {
        (kingX == rookX1 || kingY == rookY1) && (kingX == rookX2 || kingY == rookY2) -> 3
        (kingX == rookX1 || kingY == rookY1) -> 1
        (kingX == rookX2 || kingY == rookY2) -> 2
        else -> 0
    }

//  (kingX != rookX1 || kingX != rookY1) && (kingY != rookX2 || kingY != rookY2) -> return 0
/**
 * Простая
 *
 * На шахматной доске стоят черный король и белые ладья и слон
 * (ладья бьет по горизонтали и вертикали, слон — по диагоналям).
 * Проверить, есть ли угроза королю и если есть, то от кого именно.
 * Вернуть 0, если угрозы нет, 1, если угроза только от ладьи, 2, если только от слона,
 * и 3, если угроза есть и от ладьи и от слона.
 * Считать, что ладья и слон не могут загораживать друг друга.
 */
fun rookOrBishopThreatens(
    kingX: Int, kingY: Int,
    rookX: Int, rookY: Int,
    bishopX: Int, bishopY: Int
): Int =
    when {
        (abs(kingX - kingY) == abs(bishopX - bishopY)) && (kingX == rookX || kingY == rookY) -> 3
        (kingX == rookX || kingY == rookY) -> 1
        abs(kingX - kingY) == abs(bishopX - bishopY) -> 2
        else -> 0
    }
// (kingX != bishopX || kingX != bishopY) && (kingY != rookX || kingY != rookY) -> return 0


//    val rookX = x(x1 + x2 + x3 + ... xn)
//    val rookY = y(y1 + y2 + y3 + ... Yn)
//    val bishopX = (x / y)((x1 / y) + (x2 / y) + (x3 / y) + ...(xn / y))
//    val bishopY = (y / x)((y1 / x) + (y2 / x) + (y3 / x) + ...(yn / x))
//    val kingX = x
//    val kingY = y
//
//    when {
//        (kingX + kingY != (rookX + rookY) || (bishopX + bishopY)) -> 0
//        (kingX + kingY == rookX + rookY) -> 1
//        (kingX == bishopX + bishopY) -> 2
//        (kingX == (rookX + rookY) + (bishopX + bishopY)) -> 3
//
//
//    }
/**
 * Простая
 *
 * Треугольник задан длинами своих сторон a, b, c.
 * Проверить, является ли данный треугольник остроугольным (вернуть 0),
 * прямоугольным (вернуть 1) или тупоугольным (вернуть 2).
 * Если такой треугольник не существует, вернуть -1.
 */
fun triangleKind(a: Double, b: Double, c: Double): Int {
    return when {
        (a + b < c || a + c < b || b + c < a) -> -1
        ((sqr(a) + sqr(b) == sqr(c) || sqr(a) + sqr(c) == sqr(b) || sqr(b) + sqr(c) == sqr(a))) -> 1
        ((sqr(a) + sqr(b) < sqr(c) || sqr(a) + sqr(c) < sqr(b) || sqr(b) + sqr(c) < sqr(a))) -> 2
        else -> return (0)
    }
}

/**
 * Средняя
 *
 * Даны четыре точки на одной прямой: A, B, C и D.
 * Координаты точек a, b, c, d соответственно, b >= a, d >= c.
 * Найти длину пересечения отрезков AB и CD.
 * Если пересечения нет, вернуть -1.
 */
fun segmentLength(a: Int, b: Int, c: Int, d: Int): Int {
    a <= b
    c <= d
    when {
        (b < c) -> return ((b / c) / 2)
        (c < b) -> return ((b / c) / 2)
        else -> -1
    }
    return 0
}
// b >= a || d >= c
//val intersectX = (d - b) / (a - c)
//val intersectY = ((c * b - a * d) / (c - a))
//return ("x: $intersectX , y:$intersectY")
//}
// {if (x = dont exist || y = dont exist) return (-1)
// return 0

//|--------|-----|-------------|
//a        b     c              d

