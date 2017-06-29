/**
 * Created by Sebastian on 28/05/2017.
 */

function toogleWarinngModal(innerText, headerText, buttonText) {
    $("#alertModalContent").html(innerText);
    $("#alertModalHeader").html(headerText);
    $("#btnAertModal").addClass('btn-warning').html(buttonText);
    $("#alertModal").modal('show');
}

function toogleErrorModal(innerText, headerText, buttonText) {
    $("#alertModalContent").html(innerText);
    $("#alertModalHeader").html(headerText);
    $("#btnAertModal").addClass('btn-danger').html(buttonText);
    $("#alertModal").modal('show');
}

var modal;
modal = modal || (function () {
        var isOnScreen = false;
        var pleaseWaitDiv = $('<div class="modal fade" role="dialog"><div class="modal-dialog"><div class="modal-content"><div class="modal-header"><h4 class="modal-title"> Cargando...</h4></div><div class="modal-body"><div class="progress"><div class="progress-bar progress-bar-info progress-bar-striped" role="progressbar" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100" style="width: 100%"></div></div><div cla</div></div></div>');
        return {
            showPleaseWait: function () {
                if (!isOnScreen) {
                    pleaseWaitDiv.modal();
                    isOnScreen = true;
                }

            },
            hidePleaseWait: function () {
                if (isOnScreen) {
                    pleaseWaitDiv.modal('hide');
                    isOnScreen = false;
                }
            },

        };
    })();
