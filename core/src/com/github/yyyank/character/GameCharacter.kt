@file:JvmName("GameCharacter")
package com.github.yyyank.character

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.g2d.TextureAtlas
import com.badlogic.gdx.scenes.scene2d.ui.Image

/**
 * Created by yy_yank on 2016/08/12.
 */
const val GOEMON = "nigaoe_ishikawa_goemon"
const val FRUED = "nigaoe_freud"
const val SHIKOUTEI = "nigaoe_shikoutei"
const val MASAOKA_SHIKI = "nigaoe_masaoka_shiki"
const val FH_TXT = "freud.txt"
fun handleText() = Gdx.files.internal(FH_TXT)
const val FH_PNG = "freud.png"
fun handlePng() = Gdx.files.internal(FH_PNG)
fun atlas() = TextureAtlas(handleText())

fun String.region() = atlas().findRegion(this)
fun String.image() = Image(this.region())
