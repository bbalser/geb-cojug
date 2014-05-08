package modules

import geb.Module

class JqueryUIDialog extends Module {

    def dialogId

    static content = {
        dialog { $("#${dialogId}").parent('div.ui-dialog') }
        okButton { dialog.find('button.ui-button', text: 'Ok') }
        closeButton { dialog.find('button.ui-button', text: 'Close') }
    }

    boolean isVisible() {
        dialog.displayed
    }

    def ok() {
        okButton.click()
    }

    def close() {
        closeButton.click()
    }


}
