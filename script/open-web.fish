#!/usr/bin/env fish

function demo_message
  argparse -n demo_func 'h/help' 'u/url=' -- $argv
  or return 1

  if set -lq _flag_help
    echo "run-docker.fish -u/--url <MESSAGE>"
    return
  end

  set -lq _flag_message
  or set -l _flag_message "swagger-ui.html"

  open http://localhost:8080/$_flag_message
end

demo_message $argv
