package ogz.tripeaks.screens.stage

import com.badlogic.gdx.assets.AssetManager
import com.badlogic.gdx.math.MathUtils
import com.badlogic.gdx.scenes.scene2d.ui.Label
import com.badlogic.gdx.utils.Align
import com.ray3k.stripe.PopTable
import ogz.tripeaks.Constants
import ogz.tripeaks.assets.BundleAssets
import ogz.tripeaks.assets.UiSkin
import ogz.tripeaks.assets.get
import ogz.tripeaks.models.GameStatistics
import ogz.tripeaks.ui.LabelButton

class StalledDialog(
    skin: UiSkin,
    assets: AssetManager,
    stats: GameStatistics,
    callback: (StalledDialogResult) -> Unit
) : PopTable(skin) {

    init {
        val bundle = assets[BundleAssets.Bundle]

        pad(
            Constants.UI_PANEL_VERTICAL_BORDER,
            Constants.UI_PANEL_HORIZONTAL_BORDER,
            Constants.UI_PANEL_HORIZONTAL_BORDER,
            Constants.UI_PANEL_VERTICAL_BORDER,
        )

        defaults()
            .padBottom(Constants.UI_VERTICAL_SPACING + skin.extraLineSpacing)
            .align(Align.left)

        add(Label(bundle.get("stalled"), skin)).align(Align.left).expandX().colspan(2)

        row()

        add(LabelButton(skin, bundle.get("newGame")) {
            callback.invoke(StalledDialogResult.NEW_GAME)
            hide()
        })
            .padRight(MathUtils.floor(Constants.UI_HORIZONTAL_SPACING / 2f).toFloat())
            .padBottom(0f)
            .uniformX()
            .align(Align.center)
            .fillX()

        add(LabelButton(skin, bundle.get("return")) {
            callback.invoke(StalledDialogResult.RETURN)
            hide()
        })
            .padLeft(MathUtils.floor(Constants.UI_HORIZONTAL_SPACING / 2f).toFloat())
            .padBottom(0f)
            .uniformX()
            .align(Align.center)
            .fillX()

        debug = true
        isModal = true
        isHideOnUnfocus = false
    }

}

enum class StalledDialogResult {
    NEW_GAME, RETURN
}