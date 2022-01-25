<div class="modal fade" id="confirm-delete">
    <div class="modal-dialog modal-dialog-centered">
        <form action="/workspace?action=delete" method="post">


        <div class="modal-content" style="font-size: medium;line-height: 40px;">

            <!-- Modal body -->
            <div class="modal-body">
                <div class="row">
                    <i class="fas fa-exclamation-circle fa-7x" style="color: red; margin-left: 150px;"></i>
                    <input style="display: none" name="wspID" id="delete_wspID">
                </div>

                <div id="textEx">
                    <p>Are you sure you want to delete the selected workspace ?</p>
                </div>

            </div>

            <!-- Modal footer -->
            <div class="modal-footer">
                <button type="submit" class="btn btn-primary" style="margin-right: 10px; border: 1px solid blue; padding: 0px 6px; border-radius: 15px ; " data-bs-dismiss="modal">Yes, delete it !</button>
                <button type="button" class="btn btn-danger" style="margin-right: 110px;border: 1px solid red; padding: 0px 5px;border-radius: 15px ;" id="btn-cancel" data-bs-dismiss="modal">Cancel</button>

            </div>
        </div>
        </form>
    </div>
</div>