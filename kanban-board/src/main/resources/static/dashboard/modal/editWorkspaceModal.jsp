<div class="modal fade" id="editWorkspace" style="font-size: medium;">
    <div class="modal-dialog modal-md  modal-dialog-centered">
        <div class="modal-content" style="background-color: #66A3C7;border-radius: 20px;">
            <form action="${pageContext.request.contextPath}/workspace?action=edit" method="post">
                <!-- Modal Header -->
                <div class="modal-header">
                    <h4 class="modal-title">Edit Workspace</h4>
                </div>

                <!-- Modal body -->
                <div class="modal-body" style="margin-bottom: 30px; line-height: 50px;">
                    <div class="row">
                        <div class="col">
                            <label for="wspName_edit">Workspace name</label>
                            <input type="text" class="form-control" placeholder="" style="font-size: 14px" name="name_edit" id="wspName_edit" required>
                           <input style="display: none" name="wspID_edit_ID" id="id_thisWorkspace">

                        </div>
                    </div>
                </div>

                <!-- Modal footer -->
                <div class="modal-footer">
                    <button type="submit" class="btn btn-outline-primary" style="border: 1px solid #0d6efd;padding: 4px;margin-right: 10px;" data-bs-dismiss="modal">Save
                    </button>
                    <button type="button" class="btn btn-secondary" style="margin-right: 160px;border: 1px solid #E2E4E6;padding: 4px;"
                            data-bs-dismiss="modal">Close
                    </button>
                </div>
            </form>
        </div>
    </div>
</div>