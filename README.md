# pigeonhole

[![Circle CI](https://circleci.com/gh/marshi/pigeonhole/tree/master.svg?style=svg&circle-token=1acd1ad6a8214b85d9de9714fdfe586fbeea38a9)](https://circleci.com/gh/marshi/pigeonhole/tree/master)

動作確認用サーバとそれぞれのサーバにデプロイされたgitブランチの対応表を生成するツール

下の図のようにPigeonhole管理下にあるサーバとブランチが表示される

![](data:image/jpeg;base64,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)
# 機能

* HTTP POSTリクエストによってホスト名、ブランチ名を登録. CIでデプロイ後にPOSTリクエストする使い方を想定
```
# 例
curl -X POST -d Payloads={\"host\":\"${HOST_NAME}\"\,\"branch\":\"${BRANCH_NAME}\"} http://<Pigeionholeのホスト>:<ポート>/hook/deploy
```

* ダッシュボードでサーバのホスト名とブランチ名の一覧表示
* サーバ一覧表示、サーバの登録削除

# Get Started

## データベーステーブルの生成
src/main/resources/application.conf で設定されているPostgreSQLに下記のテーブルを生成する

```SQL
CREATE TABLE host_branch
(
  id serial NOT NULL,
  branch_name character varying(128),
  host_machine_id integer NOT NULL,
  deploy_time timestamp with time zone,
  CONSTRAINT id PRIMARY KEY (id),
  CONSTRAINT host_branch_host_machine_id_key UNIQUE (host_machine_id)
)

```

```SQL
CREATE TABLE host_machine
(
  id serial NOT NULL,
  name character varying(64) NOT NULL,
  CONSTRAINT host_machine_pkey PRIMARY KEY (id),
  CONSTRAINT host_machine_name_key UNIQUE (name)
)
```

## 起動

プロジェクトのルートディレクトリで下記のコマンドを実行

デフォルトで8888番ポードで起動する

```bash
./gradlew run
```

# 名前の由来
鳩の巣原理(pigeonhole principle)から拝借

開発時にサーバの取り合いを防ぐにはブランチの数だけサーバを用意しないといけない

”小さく区切られた整理棚”を表す単語でもあるので、ブランチとサーバの対応関係を整理するという意味も込めた
