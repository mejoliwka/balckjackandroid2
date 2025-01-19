package com.example.balckjackandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}


@Composable
fun MainScreen() {
    val backgroundPainter: Painter = painterResource(id = R.drawable.tlo)
    val backPainter: Painter = painterResource(id = R.drawable.back)
    val leftImagePainter: Painter = painterResource(id = R.drawable.left_image)
    val imgPainter: Painter = painterResource(id = R.drawable.img)
    val img1Painter: Painter = painterResource(id = R.drawable.img_1)
    val img2Painter: Painter = painterResource(id = R.drawable.img_2)
    val img3Painter: Painter = painterResource(id = R.drawable.img_3)
    val NewGame: Painter = painterResource(id = R.drawable.img_6)

    val selectedCards = remember { mutableStateOf(mutableListOf<Int>()) }
    val opponentCards = remember { mutableStateOf(mutableListOf<Int>()) }
    val cardSum = remember { mutableStateOf(0) }
    val opponentCardSum = remember { mutableStateOf(0) }
    val totalPoints = remember { mutableStateOf(5000) }
    val gameTokens = remember { mutableStateOf(0) }

    val cardNames = listOf(
        // Karo
        R.drawable.karo2, R.drawable.karo3, R.drawable.karo4, R.drawable.karo5, R.drawable.karo6,
        R.drawable.karo7, R.drawable.karo8, R.drawable.karo9, R.drawable.karo10, R.drawable.karoa,
        R.drawable.karoj, R.drawable.karod, R.drawable.karok,

        // Trefl
        R.drawable.trefl2, R.drawable.trefl3, R.drawable.trefl4, R.drawable.trefl5, R.drawable.trefl6,
        R.drawable.trefl7, R.drawable.trefl8, R.drawable.trefl9, R.drawable.trefl10, R.drawable.trefla,
        R.drawable.treflj, R.drawable.trefld, R.drawable.treflk,

        // Kier
        R.drawable.kier2, R.drawable.kier3, R.drawable.kier4, R.drawable.kier5, R.drawable.kier6,
        R.drawable.kier7, R.drawable.kier8, R.drawable.kier9, R.drawable.kier10, R.drawable.kiera,
        R.drawable.kierj, R.drawable.kierd, R.drawable.kierk,

        // Pik
        R.drawable.pik2, R.drawable.pik3, R.drawable.pik4, R.drawable.pik5, R.drawable.pik6,
        R.drawable.pik7, R.drawable.pik8, R.drawable.pik9, R.drawable.pik10, R.drawable.pika,
        R.drawable.pikj, R.drawable.pikd, R.drawable.pikk
    )

    val cardValues = mapOf(
        // Karo
        R.drawable.karo2 to 2, R.drawable.karo3 to 3, R.drawable.karo4 to 4, R.drawable.karo5 to 5, R.drawable.karo6 to 6,
        R.drawable.karo7 to 7, R.drawable.karo8 to 8, R.drawable.karo9 to 9, R.drawable.karo10 to 10,
        R.drawable.karoa to 10, R.drawable.karoj to 10, R.drawable.karod to 10, R.drawable.karok to 10,

        // Trefl
        R.drawable.trefl2 to 2, R.drawable.trefl3 to 3, R.drawable.trefl4 to 4, R.drawable.trefl5 to 5, R.drawable.trefl6 to 6,
        R.drawable.trefl7 to 7, R.drawable.trefl8 to 8, R.drawable.trefl9 to 9, R.drawable.trefl10 to 10,
        R.drawable.trefla to 10, R.drawable.treflj to 10, R.drawable.trefld to 10, R.drawable.treflk to 10,

        // Kier
        R.drawable.kier2 to 2, R.drawable.kier3 to 3, R.drawable.kier4 to 4, R.drawable.kier5 to 5, R.drawable.kier6 to 6,
        R.drawable.kier7 to 7, R.drawable.kier8 to 8, R.drawable.kier9 to 9, R.drawable.kier10 to 10,
        R.drawable.kiera to 10, R.drawable.kierj to 10, R.drawable.kierd to 10, R.drawable.kierk to 10,

        // Pik
        R.drawable.pik2 to 2, R.drawable.pik3 to 3, R.drawable.pik4 to 4, R.drawable.pik5 to 5, R.drawable.pik6 to 6,
        R.drawable.pik7 to 7, R.drawable.pik8 to 8, R.drawable.pik9 to 9, R.drawable.pik10 to 10,
        R.drawable.pika to 10, R.drawable.pikj to 10, R.drawable.pikd to 10, R.drawable.pikk to 10
    )

    val isPlayerDone = remember { mutableStateOf(false) }
    val isOpponentTurn = remember { mutableStateOf(false) }


    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        // Tło aplikacji
        Image(
            painter = backgroundPainter,
            contentDescription = "Tło aplikacji",
            modifier = Modifier
                .fillMaxSize()
                .graphicsLayer(
                    scaleX = 2.3f,
                    scaleY = 1.4f,
                    rotationZ = 90f
                )
        )

        // Wyświetlanie sumy kart gracza
        Text(
            text = "Suma kart: ${cardSum.value}",
            modifier = Modifier
                .align(Alignment.TopCenter)
                .offset(y = 385.dp)
                .offset(x = 60.dp)
                .graphicsLayer(
                    rotationZ = 270f
                ),
            color = Color.White
        )

        // Wyświetlanie sumy kart przeciwnika
        Text(
            text = "Suma kart: ${opponentCardSum.value}",
            modifier = Modifier
                .align(Alignment.TopCenter)
                .offset(y = 385.dp)
                .offset(x = -60.dp)
                .graphicsLayer(
                    rotationZ = 270f
                ),
            color = Color.White
        )

        // Wyświetlanie ilości punktów
        Text(
            text = "Ilość punktów: ${totalPoints.value}",
            modifier = Modifier
                .align(Alignment.BottomStart)
                .graphicsLayer(
                    rotationZ = 270f
                )
                .offset(x = 620.dp, y = (68).dp),
            color = Color.White
        )

        // Wyświetlanie żetonów w grze
        Text(
            text = "Żetony w grze: ${gameTokens.value}",
            modifier = Modifier
                .align(Alignment.BottomStart)
                .graphicsLayer(
                    rotationZ = 270f
                )
                .offset(x = 620.dp, y = (203).dp),
            color = Color.White
        )

        // Obrazek 'back' do losowania kart
        Image(
            painter = backPainter,
            contentDescription = "Obrazek 'back'",
            modifier = Modifier
                .align(Alignment.Center)
                .graphicsLayer(
                    scaleX = 0.25f,
                    scaleY = 0.25f
                )
                .clickable {
                    if (!isOpponentTurn.value) {
                        if (!isPlayerDone.value) {
                            if (selectedCards.value.isEmpty()) {
                                // Losowanie początkowych kart dla gracza i przeciwnika
                                val initialCards = getRandomUniqueCards(cardNames, 2)
                                selectedCards.value = initialCards
                                cardSum.value = initialCards.sumOf { cardValues[it] ?: 0 }

                                val initialOpponentCard = getRandomUniqueCards(cardNames, 1, selectedCards.value)
                                opponentCards.value = initialOpponentCard.toMutableList()
                                opponentCardSum.value = initialOpponentCard.sumOf { cardValues[it] ?: 0 }
                            } else {
                                // Dobieranie jednej karty dla gracza
                                val newCard = getRandomUniqueCards(cardNames, 1, selectedCards.value).first()
                                selectedCards.value = selectedCards.value.toMutableList().apply { add(newCard) }
                                cardSum.value += cardValues[newCard] ?: 0

                                // Sprawdzenie, czy suma kart gracza przekroczyła 21
                                if (cardSum.value > 21) {
                                    isPlayerDone.value = true
                                    isOpponentTurn.value = true
                                }
                            }
                        }
                    } else {
                        // Ruch przeciwnika
                        while (opponentCardSum.value < 17) {
                            val opponentNewCard = getRandomUniqueCards(cardNames, 1, opponentCards.value).first()
                            opponentCards.value = opponentCards.value.toMutableList().apply { add(opponentNewCard) }
                            opponentCardSum.value += cardValues[opponentNewCard] ?: 0

                            // Przeciwnik przestaje dobierać karty, gdy suma osiągnie zakres 17-21
                            if (opponentCardSum.value in 17..21) {
                                break
                            }
                        }
                        // Teraz, po zakończeniu tury przeciwnika, sprawdzamy warunki dotyczące żetonów:
                        // Gracz przekroczył 21 i przeciwnik ma sumę w przedziale 17-21
                        if (cardSum.value > 21 && opponentCardSum.value in 17..21) {
                            gameTokens.value = 0
                        }
                        // Gracz przekroczył 21, przeciwnik ma dokładnie 21 lub obie sumy są równe
                        else if (cardSum.value > 21 && opponentCardSum.value > 21 || cardSum.value == opponentCardSum.value) {
                            gameTokens.value = (gameTokens.value / 2) + totalPoints.value
                            totalPoints.value += gameTokens.value
                        }
                        // Gracz nie przekroczył 21, porównanie kart
                        else if (cardSum.value <= 21) {
                            // Jeśli przeciwnik w przedziale 17-21, ale ma większą sumę
                            if (opponentCardSum.value in 17..21 && opponentCardSum.value > cardSum.value) {
                                gameTokens.value = 0
                            }
                            // Jeśli przeciwnik przekroczył 21, a gracz ma poniżej 21
                            else if (opponentCardSum.value > 21 && cardSum.value <= 21) {
                                gameTokens.value *= 2
                                totalPoints.value += gameTokens.value
                            }
                            // Jeśli przeciwnik w przedziale 17-21, ale ma mniejszą sumę
                            else if (opponentCardSum.value in 17..21 && opponentCardSum.value < cardSum.value) {
                                gameTokens.value *=2
                                totalPoints.value += gameTokens.value
                            }
                        }
                    }

                }

        )






        Image(
            painter = leftImagePainter,
            contentDescription = "Lewy obrazek",
            modifier = Modifier
                .align(Alignment.CenterStart)
                .offset(x = 235.dp, y = 213.dp)
                .graphicsLayer(
                    scaleX = 0.3f,
                    scaleY = 0.3f,
                    rotationZ = 90f
                )
                .clickable {
                    if (!isPlayerDone.value) {
                        isPlayerDone.value = true
                        isOpponentTurn.value = true
                    }
                }
        )
        Image(
            painter = NewGame,
            contentDescription = "Nowa gra",
            modifier = Modifier
                .align(Alignment.CenterStart)
                .offset(x = 137.dp, y = 300.dp)
                .graphicsLayer(
                    scaleX = 0.25f,
                    scaleY = 0.25f,
                    rotationZ = 270f
                )
                .clickable {
                    if (isOpponentTurn.value) {
                        selectedCards.value = mutableListOf()
                        opponentCards.value = mutableListOf()
                        cardSum.value = 0
                        opponentCardSum.value = 0
                        gameTokens.value = 0
                        isPlayerDone.value = false
                        isOpponentTurn.value = false
                    }
                }
        )

        // Wyświetlanie wylosowanych kart gracza
        selectedCards.value.forEachIndexed { index, resId ->
            Image(
                painter = painterResource(id = resId),
                contentDescription = "Losowa karta",
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .offset(y = (-50 * index).dp, x = 200.dp)
                    .offset(y = 49.dp)
                    .graphicsLayer(
                        scaleX = 0.3f,
                        scaleY = 0.3f,
                        rotationZ = 90f
                    )
            )
        }

        // Wyświetlanie kart przeciwnika
        opponentCards.value.forEachIndexed { index, resId ->
            Image(
                painter = painterResource(id = resId),
                contentDescription = "Karta przeciwnika",
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .offset(y = (-50 * index).dp, x = -200.dp)
                    .offset(y = 49.dp)
                    .graphicsLayer(
                        scaleX = 0.3f,
                        scaleY = 0.3f,
                        rotationZ = 90f
                    )
            )
        }

        // Obrazki img, img_1, img_2, img_3, które są widoczne na ekranie
        // Obrazki img, img_1, img_2, img_3 nad lewym przyciskiem
        Image(
            painter = imgPainter,
            contentDescription = "Obrazek img",
            modifier = Modifier
                .align(Alignment.CenterStart)
                .offset(x = 80.dp, y = 300.dp)
                .graphicsLayer(
                    scaleX = 0.3f,
                    scaleY = 0.3f,
                    rotationZ = 270f
                )
                .clickable {
                    if (totalPoints.value >= 50) {
                        gameTokens.value += 50
                        totalPoints.value -= 50
                    }
                }
        )
        Image(
            painter = img1Painter,
            contentDescription = "Obrazek img_1",
            modifier = Modifier
                .align(Alignment.CenterStart)
                .offset(x = 80.dp, y = 213.dp)
                .graphicsLayer(
                    scaleX = 0.3f,
                    scaleY = 0.3f,
                    rotationZ = 270f
                )
                .clickable {
                    if (totalPoints.value >= 25) {
                        gameTokens.value += 25
                        totalPoints.value -= 25
                    }
                }
        )
        Image(
            painter = img2Painter,
            contentDescription = "Obrazek img_2",
            modifier = Modifier
                .align(Alignment.CenterStart)
                .offset(x = 28.dp, y = 213.dp)
                .graphicsLayer(
                    scaleX = 0.3f,
                    scaleY = 0.3f,
                    rotationZ = 270f
                )
                .clickable {
                    if (totalPoints.value >= 100) {
                        gameTokens.value += 100
                        totalPoints.value -= 100
                    }
                }
        )
        Image(
            painter = img3Painter,
            contentDescription = "Obrazek img_3",
            modifier = Modifier
                .align(Alignment.CenterStart)
                .offset(x = 28.dp, y = 301.dp)
                .graphicsLayer(
                    scaleX = 0.3f,
                    scaleY = 0.3f,
                    rotationZ = 270f
                )
                .clickable {
                    if (totalPoints.value >= 125) {
                        gameTokens.value += 125
                        totalPoints.value -= 125
                    }
                }
        )
    }
}

fun getRandomUniqueCards(
    cardNames: List<Int>,
    count: Int,
    exclude: List<Int> = listOf()
): MutableList<Int> {
    val availableCards = cardNames.filterNot { it in exclude }.toMutableList()
    val selectedCards = mutableListOf<Int>()
    repeat(count) {
        if (availableCards.isNotEmpty()) {
            val randomIndex = Random.nextInt(availableCards.size)
            selectedCards.add(availableCards[randomIndex])
            availableCards.removeAt(randomIndex)
        }
    }
    return selectedCards
}
