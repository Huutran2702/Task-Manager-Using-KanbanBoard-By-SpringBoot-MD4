<div class="modal fade" id="addWorkspace" style="font-size: medium;">
    <div class="modal-dialog modal-md  modal-dialog-centered">
        <div class="modal-content" style="background-color: #66A3C7;border-radius: 20px;">
            <form action="${pageContext.request.contextPath}/workspace?action=add" method="post">
                <!-- Modal Header -->
                <div class="modal-header">
                    <h4 class="modal-title">Add Workspace</h4>
                </div>

                <!-- Modal body -->
                <div class="modal-body" style="margin-bottom: 30px; line-height: 50px;">
                    <div class="row">
                        <div class="col">
                            <label for="wspName_add">Workspace name</label>
                            <input type="text" class="form-control" placeholder="" style="font-size: 14px" name="name_add" id="wspName_add" required>
<%--                            <input style="display: none" name="wspID" id="id_thisWorkspace">--%>

                        </div>
                    </div>
                </div>

                <!-- Modal footer -->
                <div class="modal-footer">
                    <button type="submit" class="btn btn-outline-primary" style="border: 1px solid #0d6efd;padding: 4px;margin-right: 10px;" data-bs-dismiss="modal">Add
                    </button>
                    <button type="button" class="btn btn-secondary" style="margin-right: 160px;border: 1px solid #E2E4E6;padding: 4px;"
                            data-bs-dismiss="modal">Close
                    </button>
                </div>
            </form>
        </div>
    </div>
</div>