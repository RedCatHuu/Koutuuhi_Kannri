

document.addEventListener('DOMContentLoaded', function () {
  const monthSelect = document.getElementById('monthSelect');
  if (monthSelect) {
    monthSelect.addEventListener('change', function () {
      const month = this.value; // 月を取得
      const url = month ? `/api/traffic?month=${month}` : `/api/traffic`; // monthが空なら全件取得　何気にシングルクオーテーションではなくバッククオート 
      fetch(url) // サーバーにリクエスト送信
        .then(res => res.json()) // ResponseオブジェクトをJSONに変換
        .then(data => {
          const tbody = document.getElementById('trafficTableBody');
          tbody.innerHTML = ''; // テーブルのデータを削除。forEachで再構成
          data.forEach(t => {
            const row = `
              <tr>
                <td>${t.dateofuse}</td>
                <td>${t.means}</td>
                <td>${t.sector}</td>
                <td>${t.road}</td>
                <td>${t.cost}</td>
              </tr>
            `;
            tbody.insertAdjacentHTML('beforeend', row); // tbody要素の最後に挿入 beforeend:要素の末尾
          });
        });
    });
  }
});
