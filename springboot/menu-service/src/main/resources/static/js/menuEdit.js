$(document).ready(function () {
    $('#updateBtn').on('click', function () {
        const menuName = $('#menuName').val().trim();
        if (!menuName) {
            alert('메뉴 이름이 비어있습니다.');
            return;
        }

        const fileInput = $('#img')[0].files[0];
        const formData = new FormData();

        if (fileInput) {
            formData.append("file", fileInput); // 새 이미지가 있으면 추가
        }

        const menuData = {
            menuName: $("input[name='menuName']").val(),
            price: parseInt($("input[name='price']").val(), 10),
            calorie: parseFloat($("input[name='calorie']").val()),
            bread: $("select[name='bread']").val(),
            material1: $("select[name='material1']").val(),
            material2: $("select[name='material2']").val() || null,
            material3: $("select[name='material3']").val() || null,
            cheese: $("select[name='cheese']").val() || null,
            vegetable1: $("select[name='vegetable1']").val(),
            vegetable2: $("select[name='vegetable2']").val() || null,
            vegetable3: $("select[name='vegetable3']").val() || null,
            vegetable4: $("select[name='vegetable4']").val() || null,
            vegetable5: $("select[name='vegetable5']").val() || null,
            vegetable6: $("select[name='vegetable6']").val() || null,
            vegetable7: $("select[name='vegetable7']").val() || null,
            vegetable8: $("select[name='vegetable8']").val() || null,
            sauce1: $("select[name='sauce1']").val(),
            sauce2: $("select[name='sauce2']").val() || null,
            sauce3: $("select[name='sauce3']").val() || null,
            status: $("select[name='status']").val() === "active" ? "ACTIVE" : "DELETED",
            img: $("#imgUrl").val() // 기존 이미지 URL도 포함 (백엔드에서 덮어쓰기 용도)
        };

        // JSON을 Blob으로 만들어 FormData에 넣기
        const jsonBlob = new Blob([JSON.stringify(menuData)], { type: "application/json" });
        formData.append("menu", jsonBlob);

        // PUT 요청 전송
        $.ajax({
            url: "/menus/" + encodeURIComponent(menuName),
            type: "PUT",
            data: formData,
            processData: false,
            contentType: false,
            success: function () {
                alert("메뉴 정보가 성공적으로 수정되었습니다.");
                window.location.href = "/menus/list";
            },
            error: function (xhr) {
                console.error("수정 실패:", xhr.responseText);
                alert("수정 중 오류가 발생했습니다.");
            }
        });
    });
});
